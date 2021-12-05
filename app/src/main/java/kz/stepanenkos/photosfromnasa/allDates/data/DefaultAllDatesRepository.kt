package kz.stepanenkos.photosfromnasa.allDates.data

import kz.stepanenkos.photosfromnasa.allDates.data.datasource.AllDatesDataSource
import kz.stepanenkos.photosfromnasa.allDates.domain.AllDatesRepository
import kz.stepanenkos.photosfromnasa.allDates.domain.models.AllDatesData
import kz.stepanenkos.photosfromnasa.utils.mappers.AllDatesApiDataMapper

class DefaultAllDatesRepository(
    private val allDatesDataSource: AllDatesDataSource,
    private val allDatesApiDataMapper: AllDatesApiDataMapper
) : AllDatesRepository {
    override suspend fun getAllDates(): List<AllDatesData> {
        return allDatesApiDataMapper.mapToListAllDatesData(allDatesDataSource.getAllDates())
    }
}