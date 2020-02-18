/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dk.nodes.nstack.kotlin.codegen.models

import com.squareup.moshi.Json

/**
 * 
 * @property tattooArtistAt 
 * @property skills 
 * @property guest 
 * @property allWorkplaces 
 * @property add 
 * @property edit 
 * @property addWorkplace 
 * @property done 
 * @property areYouGuest 
 * @property startDate 
 * @property endDate 
 * @property chooseMaxSkills 
 * @property alreadyPickedTitle 
 * @property alreadyPickedDescription 
 * @property ok 
 * @property okay 
 * @property searchShops 
 * @property showYourExperience 
 * @property cantFindShop 
 * @property createShop 
 * @property noResultsFor 
 * @property theShopDoesNotExist 
 * @property cancel 
 * @property use 
 * @property name 
 * @property deleteThisPromptTitle 
 * @property deleteThisPromptDescription 
 * @property present 
 * @property createNew 
 * @property editWorkplace 
 * @property pleaseSelectStartDate 
 * @property pleaseSelectEndDateAfterStartDate 
 * @property workplaces 
 * @property now 
 * @property sharePortfolio 
 * @property noWorkplaces 
 * @property noWorkplacesSubtitle 
 * @property delete 
 * @property searchArtists 
 * @property work 
 * @property preferredStyles 
 * @property worksAt 
 * @property about 
 * @property whereDoYouWork 
 * @property previousWorkplaces 
 * @property guestArtist 
 * @property tabWork 
 * @property tabBoards 
 * @property tabAbout 
 * @property addBio 
 * @property noBio 
 * @property styles 
 * @property noStyles 
 * @property noStylesSubtitle 
 * @property addStyles 
 * @property tabMyCollection 
 */
data class Artist (
        @Json(name = "tattooArtistAt") @field:Json(name = "tattooArtistAt") var tattooArtistAt: String,
        @Json(name = "skills") @field:Json(name = "skills") var skills: String,
        @Json(name = "guest") @field:Json(name = "guest") var guest: String,
        @Json(name = "allWorkplaces") @field:Json(name = "allWorkplaces") var allWorkplaces: String,
        @Json(name = "add") @field:Json(name = "add") var add: String,
        @Json(name = "edit") @field:Json(name = "edit") var edit: String,
        @Json(name = "addWorkplace") @field:Json(name = "addWorkplace") var addWorkplace: String,
        @Json(name = "done") @field:Json(name = "done") var done: String,
        @Json(name = "areYouGuest") @field:Json(name = "areYouGuest") var areYouGuest: String,
        @Json(name = "startDate") @field:Json(name = "startDate") var startDate: String,
        @Json(name = "endDate") @field:Json(name = "endDate") var endDate: String,
        @Json(name = "chooseMaxSkills") @field:Json(name = "chooseMaxSkills") var chooseMaxSkills: String,
        @Json(name = "alreadyPickedTitle") @field:Json(name = "alreadyPickedTitle") var alreadyPickedTitle: String,
        @Json(name = "alreadyPickedDescription") @field:Json(name = "alreadyPickedDescription") var alreadyPickedDescription: String,
        @Json(name = "ok") @field:Json(name = "ok") var ok: String,
        @Json(name = "okay") @field:Json(name = "okay") var okay: String,
        @Json(name = "searchShops") @field:Json(name = "searchShops") var searchShops: String,
        @Json(name = "showYourExperience") @field:Json(name = "showYourExperience") var showYourExperience: String,
        @Json(name = "cantFindShop") @field:Json(name = "cantFindShop") var cantFindShop: String,
        @Json(name = "createShop") @field:Json(name = "createShop") var createShop: String,
        @Json(name = "noResultsFor") @field:Json(name = "noResultsFor") var noResultsFor: String,
        @Json(name = "theShopDoesNotExist") @field:Json(name = "theShopDoesNotExist") var theShopDoesNotExist: String,
        @Json(name = "cancel") @field:Json(name = "cancel") var cancel: String,
        @Json(name = "use") @field:Json(name = "use") var use: String,
        @Json(name = "name") @field:Json(name = "name") var name: String,
        @Json(name = "deleteThisPromptTitle") @field:Json(name = "deleteThisPromptTitle") var deleteThisPromptTitle: String,
        @Json(name = "deleteThisPromptDescription") @field:Json(name = "deleteThisPromptDescription") var deleteThisPromptDescription: String,
        @Json(name = "present") @field:Json(name = "present") var present: String,
        @Json(name = "createNew") @field:Json(name = "createNew") var createNew: String,
        @Json(name = "editWorkplace") @field:Json(name = "editWorkplace") var editWorkplace: String,
        @Json(name = "pleaseSelectStartDate") @field:Json(name = "pleaseSelectStartDate") var pleaseSelectStartDate: String,
        @Json(name = "pleaseSelectEndDateAfterStartDate") @field:Json(name = "pleaseSelectEndDateAfterStartDate") var pleaseSelectEndDateAfterStartDate: String,
        @Json(name = "workplaces") @field:Json(name = "workplaces") var workplaces: String,
        @Json(name = "now") @field:Json(name = "now") var now: String,
        @Json(name = "sharePortfolio") @field:Json(name = "sharePortfolio") var sharePortfolio: String,
        @Json(name = "noWorkplaces") @field:Json(name = "noWorkplaces") var noWorkplaces: String,
        @Json(name = "noWorkplacesSubtitle") @field:Json(name = "noWorkplacesSubtitle") var noWorkplacesSubtitle: String,
        @Json(name = "delete") @field:Json(name = "delete") var delete: String,
        @Json(name = "searchArtists") @field:Json(name = "searchArtists") var searchArtists: String,
        @Json(name = "work") @field:Json(name = "work") var work: String,
        @Json(name = "preferredStyles") @field:Json(name = "preferredStyles") var preferredStyles: String,
        @Json(name = "worksAt") @field:Json(name = "worksAt") var worksAt: String,
        @Json(name = "about") @field:Json(name = "about") var about: String,
        @Json(name = "whereDoYouWork") @field:Json(name = "whereDoYouWork") var whereDoYouWork: String,
        @Json(name = "previousWorkplaces") @field:Json(name = "previousWorkplaces") var previousWorkplaces: String,
        @Json(name = "guestArtist") @field:Json(name = "guestArtist") var guestArtist: String,
        @Json(name = "tabWork") @field:Json(name = "tabWork") var tabWork: String,
        @Json(name = "tabBoards") @field:Json(name = "tabBoards") var tabBoards: String,
        @Json(name = "tabAbout") @field:Json(name = "tabAbout") var tabAbout: String,
        @Json(name = "addBio") @field:Json(name = "addBio") var addBio: String,
        @Json(name = "noBio") @field:Json(name = "noBio") var noBio: String,
        @Json(name = "styles") @field:Json(name = "styles") var styles: String,
        @Json(name = "noStyles") @field:Json(name = "noStyles") var noStyles: String,
        @Json(name = "noStylesSubtitle") @field:Json(name = "noStylesSubtitle") var noStylesSubtitle: String,
        @Json(name = "addStyles") @field:Json(name = "addStyles") var addStyles: String,
        @Json(name = "tabMyCollection") @field:Json(name = "tabMyCollection") var tabMyCollection: String
)

