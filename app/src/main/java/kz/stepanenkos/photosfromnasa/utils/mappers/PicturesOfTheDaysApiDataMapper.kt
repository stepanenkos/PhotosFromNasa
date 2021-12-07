package kz.stepanenkos.photosfromnasa.utils.mappers

import kz.stepanenkos.photosfromnasa.allDates.data.models.PicturesOfTheDaysApiData
import kz.stepanenkos.photosfromnasa.allDates.domain.models.PicturesOfTheDaysData

private const val DEFAULT_DATE = ""
private const val DEFAULT_TITLE = ""
private const val DEFAULT_COPYRIGHT = ""
private const val DEFAULT_MEDIA_TYPE = ""
private const val DEFAULT_URL = ""
private const val DEFAULT_HD_URL = ""
private const val DEFAULT_EXPLANATION = ""

class PicturesOfTheDaysApiDataMapper {

    fun map(picturesOfTheDaysApiData: List<PicturesOfTheDaysApiData>?): List<PicturesOfTheDaysData> {
        picturesOfTheDaysApiData ?: return emptyList()

        return picturesOfTheDaysApiData.map {
            PicturesOfTheDaysData(
                title = it.title ?: DEFAULT_TITLE,
                date = it.date ?: DEFAULT_DATE,
                explanation = it.explanation ?: DEFAULT_EXPLANATION,
                copyright = it.copyright ?: DEFAULT_COPYRIGHT,
                url = it.url ?: DEFAULT_URL,
                hdUrl = it.hdUrl ?: DEFAULT_HD_URL,
                mediaType = it.mediaType ?: DEFAULT_MEDIA_TYPE
            )
        }
    }

    fun map(picturesOfTheDaysApiData: PicturesOfTheDaysApiData): PicturesOfTheDaysData {
        return PicturesOfTheDaysData(
            title = picturesOfTheDaysApiData.title ?: DEFAULT_TITLE,
            date = picturesOfTheDaysApiData.date ?: DEFAULT_DATE,
            explanation = picturesOfTheDaysApiData.explanation ?: DEFAULT_EXPLANATION,
            copyright = picturesOfTheDaysApiData.copyright ?: DEFAULT_COPYRIGHT,
            url = picturesOfTheDaysApiData.url ?: DEFAULT_URL,
            hdUrl = picturesOfTheDaysApiData.hdUrl ?: DEFAULT_HD_URL,
            mediaType = picturesOfTheDaysApiData.mediaType ?: DEFAULT_MEDIA_TYPE
        )
    }

}