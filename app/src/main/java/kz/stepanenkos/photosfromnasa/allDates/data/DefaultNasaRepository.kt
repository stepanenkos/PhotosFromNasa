package kz.stepanenkos.photosfromnasa.allDates.data

import kz.stepanenkos.photosfromnasa.allDates.data.datasource.NasaDataSource
import kz.stepanenkos.photosfromnasa.allDates.domain.NasaRepository
import kz.stepanenkos.photosfromnasa.allDates.domain.models.PicturesOfTheDaysData
import kz.stepanenkos.photosfromnasa.utils.helpers.time.TimeHelper
import kz.stepanenkos.photosfromnasa.utils.mappers.PicturesOfTheDaysApiDataMapper
import kz.stepanenkos.photosfromnasa.utils.model.ResponseData

class DefaultNasaRepository(
    private val nasaDataSource: NasaDataSource,
    private val picturesOfTheDaysApiDataMapper: PicturesOfTheDaysApiDataMapper
) : NasaRepository {
    override suspend fun getPicturesOfTheRangeDays(startTime: String): ResponseData<List<PicturesOfTheDaysData>, Exception> {

        return try {
            val allDates = nasaDataSource.getPicturesOfTheRangeDays(startTime)
            if(allDates.isSuccessful) {
                val body = allDates.body()?.reversed()

                ResponseData.Success(picturesOfTheDaysApiDataMapper.map(body))
            } else {
                ResponseData.Error(Exception(allDates.errorBody()?.string()))
            }
        } catch (e: Exception) {
            ResponseData.Error(e)
        }
    }
}