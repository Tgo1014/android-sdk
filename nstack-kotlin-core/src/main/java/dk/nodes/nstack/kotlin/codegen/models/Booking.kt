/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dk.nodes.nstack.kotlin.codegen.models

import com.squareup.moshi.Json

/**
 * 
 * @property bookingError 
 * @property title 
 * @property subtitle 
 * @property phoneNumberTitle 
 * @property phoneNumberHint 
 * @property preferredArtistTitle 
 * @property preferredArtistHint 
 * @property describeTattooTitle 
 * @property describeTattooHint 
 * @property requestNowButton 
 * @property contactInformationButton 
 * @property bookingConfirmationTitle 
 * @property bookingConfirmationSubtitle 
 * @property bookingConfirmationButtonLabel 
 */
data class Booking (
        @Json(name = "bookingError") @field:Json(name = "bookingError") var bookingError: String,
        @Json(name = "title") @field:Json(name = "title") var title: String,
        @Json(name = "subtitle") @field:Json(name = "subtitle") var subtitle: String,
        @Json(name = "phoneNumberTitle") @field:Json(name = "phoneNumberTitle") var phoneNumberTitle: String,
        @Json(name = "phoneNumberHint") @field:Json(name = "phoneNumberHint") var phoneNumberHint: String,
        @Json(name = "preferredArtistTitle") @field:Json(name = "preferredArtistTitle") var preferredArtistTitle: String,
        @Json(name = "preferredArtistHint") @field:Json(name = "preferredArtistHint") var preferredArtistHint: String,
        @Json(name = "describeTattooTitle") @field:Json(name = "describeTattooTitle") var describeTattooTitle: String,
        @Json(name = "describeTattooHint") @field:Json(name = "describeTattooHint") var describeTattooHint: String,
        @Json(name = "requestNowButton") @field:Json(name = "requestNowButton") var requestNowButton: String,
        @Json(name = "contactInformationButton") @field:Json(name = "contactInformationButton") var contactInformationButton: String,
        @Json(name = "bookingConfirmationTitle") @field:Json(name = "bookingConfirmationTitle") var bookingConfirmationTitle: String,
        @Json(name = "bookingConfirmationSubtitle") @field:Json(name = "bookingConfirmationSubtitle") var bookingConfirmationSubtitle: String,
        @Json(name = "bookingConfirmationButtonLabel") @field:Json(name = "bookingConfirmationButtonLabel") var bookingConfirmationButtonLabel: String
)

