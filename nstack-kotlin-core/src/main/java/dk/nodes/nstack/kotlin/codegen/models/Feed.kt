/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dk.nodes.nstack.kotlin.codegen.models

import com.squareup.moshi.Json

/**
 * 
 * @property title 
 * @property noPosts 
 * @property goDiscover 
 * @property report 
 * @property edit 
 * @property delete 
 * @property reportTitle 
 * @property reportMessage 
 * @property deleteTitle 
 * @property deleteMessage 
 * @property postNotFoundTitle 
 * @property postNotFoundMessage 
 * @property postAlreadyReportedTitle 
 * @property postAlreadyReportedMessage 
 * @property postDeleteNotUsersMessage 
 * @property myBody 
 * @property likeSingular 
 * @property likePlural 
 * @property reportSuccess 
 * @property option 
 * @property deleteSuccess 
 * @property deleteCancel 
 * @property reportCancel 
 * @property photoTitle 
 * @property peopleYouFollow 
 * @property findPeopleToFollow 
 * @property skip 
 * @property suggestedProfiles 
 * @property tattoosOfTheDay 
 * @property coverStories 
 * @property discoverTattooStyles 
 */
data class Feed (
        @Json(name = "title") @field:Json(name = "title") var title: String,
        @Json(name = "noPosts") @field:Json(name = "noPosts") var noPosts: String,
        @Json(name = "goDiscover") @field:Json(name = "goDiscover") var goDiscover: String,
        @Json(name = "report") @field:Json(name = "report") var report: String,
        @Json(name = "edit") @field:Json(name = "edit") var edit: String,
        @Json(name = "delete") @field:Json(name = "delete") var delete: String,
        @Json(name = "reportTitle") @field:Json(name = "reportTitle") var reportTitle: String,
        @Json(name = "reportMessage") @field:Json(name = "reportMessage") var reportMessage: String,
        @Json(name = "deleteTitle") @field:Json(name = "deleteTitle") var deleteTitle: String,
        @Json(name = "deleteMessage") @field:Json(name = "deleteMessage") var deleteMessage: String,
        @Json(name = "postNotFoundTitle") @field:Json(name = "postNotFoundTitle") var postNotFoundTitle: String,
        @Json(name = "postNotFoundMessage") @field:Json(name = "postNotFoundMessage") var postNotFoundMessage: String,
        @Json(name = "postAlreadyReportedTitle") @field:Json(name = "postAlreadyReportedTitle") var postAlreadyReportedTitle: String,
        @Json(name = "postAlreadyReportedMessage") @field:Json(name = "postAlreadyReportedMessage") var postAlreadyReportedMessage: String,
        @Json(name = "postDeleteNotUsersMessage") @field:Json(name = "postDeleteNotUsersMessage") var postDeleteNotUsersMessage: String,
        @Json(name = "myBody") @field:Json(name = "myBody") var myBody: String,
        @Json(name = "likeSingular") @field:Json(name = "likeSingular") var likeSingular: String,
        @Json(name = "likePlural") @field:Json(name = "likePlural") var likePlural: String,
        @Json(name = "reportSuccess") @field:Json(name = "reportSuccess") var reportSuccess: String,
        @Json(name = "option") @field:Json(name = "option") var option: String,
        @Json(name = "deleteSuccess") @field:Json(name = "deleteSuccess") var deleteSuccess: String,
        @Json(name = "deleteCancel") @field:Json(name = "deleteCancel") var deleteCancel: String,
        @Json(name = "reportCancel") @field:Json(name = "reportCancel") var reportCancel: String,
        @Json(name = "photoTitle") @field:Json(name = "photoTitle") var photoTitle: String,
        @Json(name = "peopleYouFollow") @field:Json(name = "peopleYouFollow") var peopleYouFollow: String,
        @Json(name = "findPeopleToFollow") @field:Json(name = "findPeopleToFollow") var findPeopleToFollow: String,
        @Json(name = "skip") @field:Json(name = "skip") var skip: String,
        @Json(name = "suggestedProfiles") @field:Json(name = "suggestedProfiles") var suggestedProfiles: String,
        @Json(name = "tattoosOfTheDay") @field:Json(name = "tattoosOfTheDay") var tattoosOfTheDay: String,
        @Json(name = "coverStories") @field:Json(name = "coverStories") var coverStories: String,
        @Json(name = "discoverTattooStyles") @field:Json(name = "discoverTattooStyles") var discoverTattooStyles: String
)

