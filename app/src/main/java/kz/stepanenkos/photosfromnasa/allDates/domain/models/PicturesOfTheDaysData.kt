package kz.stepanenkos.photosfromnasa.allDates.domain.models

import com.fasterxml.jackson.annotation.JsonProperty

data class PicturesOfTheDaysData(
    val title: String,
    val copyright: String,
    val explanation: String,
    val hdUrl: String,
    val url: String,
    val date: String,
    val mediaType: String
)
