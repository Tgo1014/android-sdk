/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dk.nodes.nstack.kotlin.codegen.apis

import okhttp3.RequestBody

import io.reactivex.Completable
import retrofit2.http.GET
import retrofit2.http.Headers

@JvmSuppressWildcards
interface DashboardsApi {
  /** 
   * Dashboard
   * Get Dashboard  #### Request details Method: `GET`  URL: `api/v2/content/dashboards/{key}`  #### URL Parameters `key` (string) **required**  `mode` (string) **Optional**   - standard (default), using cache data  - fresh, force using fresh data  - test, fake data  #### Response codes(s) `200` OK  `404` Entity not found
   * The endpoint is owned by NStack v2 service owner
   */
  @Headers(
    "X-Operation-Id: Dashboard",
    "Content-Type: application/json"
  )
  @GET("api/v2/content/dashboards/DAS-ad21e084-ae03-4486-a5ec-d837dfc56fd2")
  fun dashboard()
    : Completable

  /** 
   * Visualization
   * Get visualization  #### Request details Method: `GET`  URL: `api/v2/content/dashboards/visualizations/{key}`  #### URL Parameters `key` (string) **required**  ### Query parameters  `mode` (string) **Optional**   - standard (default), using cache data  - fresh, force using fresh data  - test, fake data  #### Response codes(s) `200` OK  `404` Entity not found
   * The endpoint is owned by NStack v2 service owner
   */
  @Headers(
    "X-Operation-Id: Visualization",
    "Content-Type: application/json"
  )
  @GET("api/v2/content/dashboards/visualizations/visualization-5d0dbc254bc83")
  fun visualization()
    : Completable

}
