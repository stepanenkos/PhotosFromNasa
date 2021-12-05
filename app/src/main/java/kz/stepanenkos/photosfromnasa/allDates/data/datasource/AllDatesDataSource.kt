package kz.stepanenkos.photosfromnasa.allDates.data.datasource

import kz.stepanenkos.photosfromnasa.allDates.data.models.AllDatesApiData
import retrofit2.http.GET

interface AllDatesDataSource {

    @GET ("natural/all")
    suspend fun getAllDates() : List<AllDatesApiData>
}