/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dk.nodes.nstack.kotlin.codegen.models

import com.squareup.moshi.Json

/**
 * 
 * @property currentPassword 
 * @property newPassword 
 * @property repeatNewPassword 
 * @property submit 
 * @property title 
 * @property changePasswordSuccess 
 * @property writeHere 
 * @property tooShort 
 * @property passwordsDontMatch 
 * @property required 
 * @property passwordsMatch 
 * @property passwordPlaceholder 
 */
data class ChangePassword (
        @Json(name = "currentPassword") @field:Json(name = "currentPassword") var currentPassword: String,
        @Json(name = "newPassword") @field:Json(name = "newPassword") var newPassword: String,
        @Json(name = "repeatNewPassword") @field:Json(name = "repeatNewPassword") var repeatNewPassword: String,
        @Json(name = "submit") @field:Json(name = "submit") var submit: String,
        @Json(name = "title") @field:Json(name = "title") var title: String,
        @Json(name = "changePasswordSuccess") @field:Json(name = "changePasswordSuccess") var changePasswordSuccess: String,
        @Json(name = "writeHere") @field:Json(name = "writeHere") var writeHere: String,
        @Json(name = "tooShort") @field:Json(name = "tooShort") var tooShort: String,
        @Json(name = "passwordsDontMatch") @field:Json(name = "passwordsDontMatch") var passwordsDontMatch: String,
        @Json(name = "required") @field:Json(name = "required") var required: String,
        @Json(name = "passwordsMatch") @field:Json(name = "passwordsMatch") var passwordsMatch: String,
        @Json(name = "passwordPlaceholder") @field:Json(name = "passwordPlaceholder") var passwordPlaceholder: String
)

