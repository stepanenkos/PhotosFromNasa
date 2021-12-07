package kz.stepanenkos.photosfromnasa.allDates.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PicturesOfTheDaysApiData(
    @JsonProperty("title")
    val title: String? = "",
    @JsonProperty("copyright")
    val copyright: String? = "",
    @JsonProperty("explanation")
    val explanation: String? = "",
    @JsonProperty("hdurl")
    val hdUrl: String? = "",
    @JsonProperty("url")
    val url: String? = "",
    @JsonProperty("date")
    val date: String? = "",
    @JsonProperty("media_type")
    val mediaType: String? = ""
)
