package kz.stepanenkos.photosfromnasa.allDates.domain

import androidx.annotation.WorkerThread
import kz.stepanenkos.photosfromnasa.allDates.domain.models.PicturesOfTheDaysData
import kz.stepanenkos.photosfromnasa.utils.model.ResponseData

interface NasaRepository {
    @WorkerThread
    suspend fun getPicturesOfTheRangeDays(startTime: String) : ResponseData<List<PicturesOfTheDaysData>, Exception>
}