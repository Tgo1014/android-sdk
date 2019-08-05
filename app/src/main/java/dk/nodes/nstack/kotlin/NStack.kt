package dk.nodes.nstack.kotlin

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.View
import dk.nodes.nstack.kotlin.managers.*
import dk.nodes.nstack.kotlin.models.*
import dk.nodes.nstack.kotlin.providers.ManagersModule
import dk.nodes.nstack.kotlin.providers.NStackModule
import dk.nodes.nstack.kotlin.util.*
import org.json.JSONObject
import java.lang.ref.WeakReference
import java.util.*

/**
 * NStack
 */
@SuppressLint("StaticFieldLeak")
object NStack {

    // Has our app been started yet?
    private var isInitialized: Boolean = false

    // Variables
    var appIdKey: String = ""
        private set(value) {
            field = value
        }
    var appApiKey: String = ""
        private set(value) {
            field = value
        }
    var env: String = ""
        private set(value) {
            field = value
        }

    val appClientInfo: ClientAppInfo
        get() = appInfo

    // Internally used classes
    private lateinit var classTranslationManager: ClassTranslationManager
    private lateinit var viewTranslationManager: ViewTranslationManager
    private lateinit var assetCacheManager: AssetCacheManager
    private lateinit var connectionManager: ConnectionManager
    private lateinit var appInfo: ClientAppInfo
    private lateinit var networkManager: NetworkManager
    private lateinit var appOpenSettingsManager: AppOpenSettingsManager
    private lateinit var prefManager: PrefManager
    private lateinit var contextWrapper: ContextWrapper

    // Cache Maps
    private var networkLanguages: Map<Locale, JSONObject>? = null
    private var cacheLanguages: Map<Locale, JSONObject> = hashMapOf()

    /**
     * Device Change Broadcast Listener
     *
     * Will listen for any changes in the device locale and send out the new locale for the user to do whatever they need to with
     */
    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            val newLocale = context.resources.configuration.locale
            if (autoChangeLanguage) {
                language = newLocale
            }
        }
    }

    /**
     * A map of all available languages keyed by their locale
     *
     * Will return the network languages if available if not it will return the
     * asset cache languages (Will typically be the oldest version of the language)
     */
    val languages: Map<Locale, JSONObject>
        get() {
            return if (networkLanguages == null || networkLanguages?.size == 0) {
                cacheLanguages
            } else {
                networkLanguages ?: cacheLanguages
            }
        }


    // Listener Lists
    private var onLanguageChangedList: ArrayList<LanguageListener?> = arrayListOf()
    private var onLanguagesChangedList: ArrayList<LanguagesListener?> = arrayListOf()

    /**
     * Listener specifically for listening for any app update events
     */
    var onAppUpdateListener: ((AppUpdateData) -> Unit)? = null

    // States
    /**
     * Set the class for our translation class
     */
    var translationClass: Class<*>?
        set(value) {
            ClassTranslationManager.translationClass = value
        }
        get() {
            return ClassTranslationManager.translationClass
        }

    /**
     * Custom Request URL
     * Used for settings a custom end point for us to pull our NStack Translations from
     */
    var customRequestUrl: String? = null

    var baseUrl = "https://nstack.io"

    var defaultLanguage: Locale = Locale.US

    /**
     * Used for settings or getting the current locale selected for language
     */
    var language: Locale = Locale.getDefault()
        set(value) {
            field = value
            onLanguageChanged()
        }

    /**
     * Return a list of all available languages
     */
    val availableLanguages: ArrayList<Locale>
        get() {
            return ArrayList(languages.keys)
        }

    var skipNetworkLoading: Boolean = false

    /**
     * Enable/Disable debug mode
     */
    var debugMode: Boolean
        get() = NLog.enableLogging
        set(value) {
            NLog.enableLogging = value
        }

    /**
     * Set the level at which the debug log should output
     */
    var debugLogLevel: NLog.Level
        get() {
            return NLog.level
        }
        set(value) {
            NLog.level
        }

    /**
     * If flag is set to true this will auto change NStack's language when the device's locale is changed
     */
    var autoChangeLanguage: Boolean = false

    /**
     * Class Start
     */
    fun init(context: Context) {
        NLog.i(this, "NStack initializing")

        if (isInitialized) {
            NLog.w(this, "NStack already initialized")
            return
        }

        val nstackModule = NStackModule(context)
        val managersModule = ManagersModule(nstackModule, context)

        val nstackMeta = nstackModule.provideNStackMeta()
        appIdKey = nstackMeta.appIdKey
        appApiKey = nstackMeta.apiKey
        env = nstackMeta.env

        viewTranslationManager = nstackModule.provideViewTranslationManager()
        classTranslationManager = nstackModule.provideClassTranslationManager()

        registerLocaleChangeBroadcastListener(context)

        networkManager = nstackModule.provideNetworkManager()
        connectionManager = nstackModule.provideConnectionManager()
        assetCacheManager = managersModule.provideAssetCacheManager()
        appInfo = nstackModule.provideClientAppInfo()
        appOpenSettingsManager = managersModule.provideAppOpenSettingsManager()
        prefManager = managersModule.providePrefManager()
        contextWrapper = nstackModule.provideContextWrapper()

        loadCacheTranslations()

        isInitialized = true
    }

    /**
     *  Allows the user to set the language via string
     *  Should match the format below
     *  en_GB
     *  en-GB
     *
     *  This method will only care about the first front letters
     */
    fun setLanguageByString(localeString: String) {
        language = localeString.locale
    }

    /**
     * Callback method for when the app is first opened
     */
    fun appOpen(callback: AppOpenCallback = {}) {
        if (!isInitialized) {
            throw IllegalStateException("init() has not been called")
        }

        val localeString = language.toString()

        val appOpenSettings = appOpenSettingsManager.getAppOpenSettings()

        NLog.d(this, "onAppOpened -> $localeString $appOpenSettings")

        // If we aren't connected we should just send the app open call back as none
        if (!connectionManager.isConnected) {
            NLog.e(this, "No internet skipping appOpen")
            onAppUpdateListener?.invoke(AppUpdateData())
            return
        }

        networkManager
            .postAppOpen(appOpenSettings, localeString,
                { appUpdate ->
                    NLog.d(this, "NStack appOpen")

                    appUpdate.localize.forEach { localizeIndex ->
                        if (localizeIndex.shouldUpdate) {
                            networkManager.loadTranslation(localizeIndex.url, {
                                prefManager.setTranslations(localizeIndex.language.locale, it)
                            }, {
                                NLog.e(this, "Could not load translations for ${localizeIndex.language.locale}", it)
                            })

                            appOpenSettingsManager.setUpdateDate()
                        }
                        if (localizeIndex.language.isDefault) {
                            defaultLanguage = localizeIndex.language.locale
                        }
                    }

                    contextWrapper.runUiAction {
                        callback.invoke(true)
                        onAppUpdateListener?.invoke(appUpdate)
                    }
                },
                {
                    NLog.e(this, "Error: onAppOpened", it)

                    // If our update failed for whatever reason we should still send an no update start
                    callback.invoke(false)
                    onAppUpdateListener?.invoke(AppUpdateData())
                }
            )
    }

    /**
     * Coroutine version of AppOpen: Callback method for when the app is first opened
     *
     */
    suspend fun appOpen(): AppOpenResult {
        if (!isInitialized) {
            throw IllegalStateException("init() has not been called")
        }

        val localeString = language.toString()
        val appOpenSettings = appOpenSettingsManager.getAppOpenSettings()

        NLog.d(this, "onAppOpened -> $localeString $appOpenSettings")

        // If we aren't connected we should just send the app open call back as none
        if (!connectionManager.isConnected) {
            NLog.e(this, "No internet skipping appOpen")
            return AppOpenResult.NoInternet
        }

        try {
            return when (val result = networkManager.postAppOpen(appOpenSettings, localeString)) {
                is AppOpenResult.Success -> {
                    NLog.d(this, "NStack appOpen")
                    result.appUpdateResponse.data.localize.forEach { handleLocalizeIndex(it) }
                    result
                }
                else -> {
                    NLog.e(this, "Error: onAppOpened")
                    result
                }
            }
        } catch (e: Exception) {
            NLog.e(this, "Error: onAppOpened - network request probably failed")
            return AppOpenResult.Failure
        }
    }

    private suspend fun handleLocalizeIndex(index: LocalizeIndex) {
        if (index.shouldUpdate) {
            val translation = networkManager.loadTranslation(index.url) ?: return
            prefManager.setTranslations(index.language.locale, translation)
            appOpenSettingsManager.setUpdateDate()
        }
        if (index.language.isDefault) {
            defaultLanguage = index.language.locale
        }
    }

    /**
     * Call it to notify that the message was seen and doesn't need to appear anymore
     */
    fun messageSeen(message: Message) {
        val appOpenSettings = appOpenSettingsManager.getAppOpenSettings()
        networkManager.postMessageSeen(appOpenSettings.guid, message.id)
    }

    /**
     * Call it to notify that the rate reminder was seen and doesn't need to appear any more
     * @param rated - true if user pressed Yes, false if user pressed No, not called if user pressed Later
     */
    fun onRateReminderAction(rated: Boolean) {
        val appOpenSettings = appOpenSettingsManager.getAppOpenSettings()
        networkManager.postRateReminderSeen(appOpenSettings, rated)
    }

    /**
     * Call it to get a Response created in Collection in the given NStack application
     * @param slug - copy paste the text slug from the list of responses
     */
    fun getCollectionResponse(slug: String,
                              onSuccess: (String) -> Unit,
                              onError: (Exception) -> Unit) {
        networkManager.getResponse(slug, onSuccess, onError)
    }

    /**
     * Call it to get a Response created in Collection in the given NStack application
     * This is the coroutine version for Kotlin
     * @param slug - copy paste the text slug from the list of responses
     */
    suspend fun getCollectionResponse(slug: String): String? {
        return networkManager.getResponseSync(slug)
    }


    /**
     * Triggers a translation of all currently cached views
     */
    fun translate() {
        viewTranslationManager.translate()
    }

    /**
     * Clears all cached views
     */
    fun clearViewCache() {
        viewTranslationManager.clear()
    }

    /**
     * Call this method when you're done using the NStack Library
     */
    fun destroy(context: Context) {
        context.unregisterReceiver(broadcastReceiver)
    }

    private fun registerLocaleChangeBroadcastListener(context: Context) {
        val filter = IntentFilter(Intent.ACTION_LOCALE_CHANGED)
        context.registerReceiver(broadcastReceiver, filter)
    }

    /**
     * Loads our languages from the asset cache
     */
    private fun loadCacheTranslations() {
        NLog.e(this, "loadCacheTranslations")

        // Load our network cached data
        networkLanguages = prefManager.getTranslations()

        // Load our asset cached data
        cacheLanguages = assetCacheManager.loadTranslations()

        // Broadcast our languages changed
        onLanguagesChanged()

        // Broadcast our default language changed
        onLanguageChanged()
    }

    /**
     * On State Change Listeners
     */
    private fun onLanguageChanged() {
        val selectedLanguage = searchForLanguageByLocale(language)

        NLog.d(this, "On Language Changed: $selectedLanguage")

        selectedLanguage?.let {
            viewTranslationManager.parseTranslations(it)
            classTranslationManager.parseTranslations(it)
            onLanguageChanged(language)
        }
    }

    private fun onLanguageChanged(locale: Locale) {
        onLanguageChangedList.forEach {
            it?.onLanguageChangedListener?.onLanguageChanged(locale)
            it?.onLanguageChangedFunction?.invoke(locale)
        }
    }

    private fun onLanguagesChanged() {
        onLanguagesChangedList.forEach {
            it?.onLanguagesChangedListener?.onLanguagesChanged()
            it?.onLanguagesChangedFunction?.invoke()
        }
    }

    /**
     * Searches the available languages for any language matching the provided locale
     *
     * Provides both a perfect match or a fallback language and a default language
     */
    private fun searchForLanguageByLocale(locale: Locale): JSONObject? {
        NLog.d(this, "searchForLanguageByLocale: $locale")

        // Search for our exact language
        var languageJson = searchForLocale(locale)

        // If that fails then we search for the default language
        if (languageJson == null && defaultLanguage != locale) {
            NLog.w(this, "Locating language failed $locale, Trying default $defaultLanguage")
            languageJson = searchForLocale(defaultLanguage)
            language = defaultLanguage
        }

        // And if all else fails then we just pick the first available language and hope for the best
        if (languageJson == null) {
            val firstAvailableLanguage = availableLanguages.firstOrNull()

            NLog.w(this, "Locating Default language failed $defaultLanguage")
            NLog.w(this, "Trying first available language $firstAvailableLanguage")

            firstAvailableLanguage?.let {
                languageJson = searchForLocale(it)
                language = firstAvailableLanguage
            }
        }

        return languageJson
    }

    private fun searchForLocale(locale: Locale): JSONObject? {
        return if (languages.containsKey(language)) {
            languages[language]
        } else {
            // Search our available languages for any keys that might match
            availableLanguages
                // Do our languages match
                .filter { it.languageCode == locale.languageCode }
                // Find the value for that language
                .map { languages[it] }
                // Return the first value or null
                .firstOrNull()
        }
    }

    /**
     * Listener Methods
     */

    // Listener

    fun addLanguageChangeListener(listener: OnLanguageChangedListener) {
        onLanguageChangedList.add(LanguageListener(onLanguageChangedListener = listener))
    }

    fun removeLanguageChangeListener(listener: OnLanguageChangedListener) {
        val listenerContainer = onLanguageChangedList.firstOrNull { it?.onLanguageChangedListener == listener }
            ?: return
        onLanguageChangedList.remove(listenerContainer)
    }

    // Function

    fun addLanguageChangeListener(listener: OnLanguageChangedFunction) {
        onLanguageChangedList.add(LanguageListener(onLanguageChangedFunction = listener))
    }

    fun removeLanguageChangeListener(listener: OnLanguageChangedFunction) {
        val listenerContainer = onLanguageChangedList.firstOrNull { it?.onLanguageChangedFunction == listener }
            ?: return
        onLanguageChangedList.remove(listenerContainer)
    }

    // Languages Listeners

    // Listener

    fun addLanguagesChangeListener(listener: OnLanguagesChangedListener) {
        onLanguagesChangedList.add(LanguagesListener(onLanguagesChangedListener = listener))
    }

    fun removeLanguagesChangeListener(listener: OnLanguagesChangedListener) {
        val listenerContainer = onLanguagesChangedList.firstOrNull { it?.onLanguagesChangedListener == listener }
            ?: return
        onLanguagesChangedList.remove(listenerContainer)
    }

    //Function

    fun addLanguagesChangeListener(listener: OnLanguagesChangedFunction) {
        onLanguagesChangedList.add(LanguagesListener(onLanguagesChangedFunction = listener))
    }

    fun removeLanguagesChangeListener(listener: OnLanguagesChangedFunction) {
        val listenerContainer = onLanguagesChangedList.firstOrNull { it?.onLanguagesChangedFunction == listener }
            ?: return
        onLanguagesChangedList.remove(listenerContainer)
    }

    /**
     * Exposed Adders(?)
     */
    fun addCachedView(weakView: WeakReference<View>, translationData: TranslationData) {
        viewTranslationManager.addView(weakView, translationData)
    }
}
