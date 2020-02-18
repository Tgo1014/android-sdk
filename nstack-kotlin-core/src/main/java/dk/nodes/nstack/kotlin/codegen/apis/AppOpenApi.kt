/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dk.nodes.nstack.kotlin.codegen.apis

import okhttp3.RequestBody

import dk.nodes.nstack.kotlin.codegen.models.AppopenV2
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Headers
import retrofit2.http.POST

@JvmSuppressWildcards
interface AppOpenApi {
  /** 
   * App open
   * Retrieve a list of valid continents on Earth  #### Request details Method:    `GET`  URL:    `/api/v2/open`  #### Headers  `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_  `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_  `N-Meta` (string) **required** _eg: android;production;1.2.3;4.4;Samsung S7_  `Accept-Language` (string) **Optional** _eg: da-DK_  ### Form-data  `platform` (string) **required** eg: ios/android/web  `guid` (string) **required** `unique generated string` *eg: 9bc4b39a-0af5-4b54-a5a5-88ad334dbd4b*  `version` (string) **required if not web** `format: xxx.yyy.zzz` *eg: 2.0.0 / 212.01.1*  - *Current version of application*  `old_version` (string) **required if not web** `format: xxx.yyy.zzz` *eg: 2.0.0 / 212.01.1*  - *Previous version of application (Auto update can have happened)*  `last_updated` (date time, ISO8601) **optional** *eg: 2019-06-15T14:29:50+00:00*  - *Set timestamp from last app open (when localization has been synced), this will calculate which localizations should be updated*  `dev` (bool) **option, default false**  - *if true, bypass publishes and only use newest resource (set of key/values)*   `test` (bool) **option, default false**  - *if true, used the app version from \"test env\"    #### Response codes(s) `200` OK
   * The endpoint is owned by NStack v2 service owner
   * @param test  (required)
   * @param nMeta  (required)
   * @param platform  (required)
   * @param guid  (required)
   * @param version  (required)
   * @param lastUpdated  (required)
   * @param dev  (required)
   */
  @retrofit2.http.FormUrlEncoded
  @Headers(
    "X-Operation-Id: Appopen"
  )
  @POST("api/v2/open")
  fun appopen(
    @retrofit2.http.Query("test") test: Boolean,
    @retrofit2.http.Header("N-Meta") nMeta: String,
    @retrofit2.http.Field("platform") platform: String,
    @retrofit2.http.Field("guid") guid: String,
    @retrofit2.http.Field("version") version: String,
    @retrofit2.http.Field("last_updated") lastUpdated: String,
    @retrofit2.http.Field("dev") dev: Boolean
  ): Single<AppopenV2>

  /** 
   * App open
   * Registers an app-open.  _Deprecated, please use V2_  #### Request details Method: `POST`  URL: `/api/v1/open`  #### Headers `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_  `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_  `Accept-Language` (string) **Optional** _eg: da-DK_  #### Parameters `platform` (string) **required** _The platform the app was opened from e.g. [\"ios\", \"android\", \"windows\", \"web\"]_  `guid` (string) **required** _[?]_  `version` (string) **required** _[?]_  `old_version` (string) _[?]_  `last_updated` (string) _A string parsable by php's [strtotime()](http://php.net/manual/en/function.strtotime.php)-function_  `test` (bool) _Enable test mode, false equals production (only works for version control)_  #### Response codes(s) `201` Created  `412` Precondition failed  `445` Entity not found  `500` Internal server error _Please read response message_
   * The endpoint is owned by NStack v2 service owner
   * @param platform  (required)
   * @param guid  (required)
   * @param version  (required)
   * @param oldVersion  (required)
   * @param lastUpdated  (required)
   */
  @retrofit2.http.FormUrlEncoded
  @Headers(
    "X-Operation-Id: PostAppopen"
  )
  @POST("api/v1/open")
  fun postAppopen(
    @retrofit2.http.Field("platform") platform: String,
    @retrofit2.http.Field("guid") guid: String,
    @retrofit2.http.Field("version") version: String,
    @retrofit2.http.Field("old_version") oldVersion: String,
    @retrofit2.http.Field("last_updated") lastUpdated: String
  ): Completable

}
