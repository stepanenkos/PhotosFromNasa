package kz.stepanenkos.photosfromnasa.allDates.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AllDatesApiData(

    @JsonProperty("date")
    val date: String?
)
