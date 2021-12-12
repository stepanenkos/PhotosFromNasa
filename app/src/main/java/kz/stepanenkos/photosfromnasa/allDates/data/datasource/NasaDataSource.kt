package kz.stepanenkos.photosfromnasa.allDates.data.datasource

import kz.stepanenkos.photosfromnasa.allDates.data.models.PicturesOfTheDaysApiData
import kz.stepanenkos.photosfromnasa.utils.helpers.time.TimeHelper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_DATE_FORMAT = "yyyy-MM-dd"

interface NasaDataSource {

    @GET ("apod")
    suspend fun getPicturesOfTheRangeDays(
        @Query("start_date")
        startDate: String,
        @Query("end_date")
        endDate: String = TimeHelper.getToday()
    ) : Response<List<PicturesOfTheDaysApiData>>
}