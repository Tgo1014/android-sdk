package dk.nodes.kstack.providers

import android.os.Build
import dk.nodes.kstack.KStack

/**
 * Created by joso on 08/10/15.
 */
class NStackInterceptor : okhttp3.Interceptor {
    @Throws(java.io.IOException::class)
    override fun intercept(chain: okhttp3.Interceptor.Chain): okhttp3.Response {
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
                //Commented this out because it was causing issues with the cached languageHeader
                //.header("Accept-Language", NStack.getStack().getSelectedLanguageHeader())
                .header("X-Application-Id", KStack.appId)
                .header("X-Rest-Api-Key", KStack.appKey)
                .header("Accept", "application/vnd.nodes.v1+json")
                .header("N-Meta", "android;${KStack.clientAppInfo.environment};${KStack.clientAppInfo.versionName} (${KStack.clientAppInfo.versionCode});${Build.VERSION.RELEASE};${Build.MODEL}")
                .build()

        return chain.proceed(newRequest)
    }

}
