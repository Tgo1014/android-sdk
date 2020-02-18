/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dk.nodes.nstack.kotlin.codegen.models

import com.squareup.moshi.Json

/**
 * 
 * @property search 
 * @property showActivity 
 * @property shareTattoo 
 * @property signIn 
 */
data class ShortcutMenu (
        @Json(name = "search") @field:Json(name = "search") var search: String,
        @Json(name = "showActivity") @field:Json(name = "showActivity") var showActivity: String,
        @Json(name = "shareTattoo") @field:Json(name = "shareTattoo") var shareTattoo: String,
        @Json(name = "signIn") @field:Json(name = "signIn") var signIn: String
)

