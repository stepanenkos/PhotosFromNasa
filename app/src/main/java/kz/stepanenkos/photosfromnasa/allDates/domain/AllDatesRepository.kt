package kz.stepanenkos.photosfromnasa.allDates.domain

import androidx.annotation.WorkerThread
import kz.stepanenkos.photosfromnasa.allDates.domain.models.AllDatesData

interface AllDatesRepository {
    @WorkerThread
    suspend fun getAllDates() : List<AllDatesData>
}