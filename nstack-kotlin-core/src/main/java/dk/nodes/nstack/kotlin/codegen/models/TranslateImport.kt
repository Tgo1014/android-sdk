/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dk.nodes.nstack.kotlin.codegen.models

import com.squareup.moshi.Json

/**
 * 
 * @property submitBtn 
 * @property title 
 */
data class TranslateImport (
        @Json(name = "submitBtn") @field:Json(name = "submitBtn") var submitBtn: String,
        @Json(name = "title") @field:Json(name = "title") var title: String
)

