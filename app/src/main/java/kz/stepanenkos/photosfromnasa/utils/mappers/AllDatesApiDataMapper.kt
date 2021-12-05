package kz.stepanenkos.photosfromnasa.utils.mappers

import kz.stepanenkos.photosfromnasa.allDates.data.models.AllDatesApiData
import kz.stepanenkos.photosfromnasa.allDates.domain.models.AllDatesData

private const val DEFAULT_DATE = ""

class AllDatesApiDataMapper {

    fun mapToListAllDatesData(allDatesApiData: List<AllDatesApiData>?): List<AllDatesData> {
        allDatesApiData ?: return emptyList()

        return allDatesApiData.map {
            AllDatesData(
                date = it.date ?: DEFAULT_DATE
            )
        }
    }


    fun mapToListAllDatesApiData(allDatesData: List<AllDatesData>?) : List<AllDatesApiData> {
        allDatesData ?: return emptyList()

        return allDatesData.map {
            AllDatesApiData(
                date = it.date
            )
        }
    }

    fun map(allDatesApiData: AllDatesApiData?) : AllDatesData {
        return AllDatesData(
            date = allDatesApiData?.date ?: DEFAULT_DATE
        )
    }

    fun map(allDatesData: AllDatesData?) : AllDatesApiData {
        return AllDatesApiData(
            date = allDatesData?.date ?: DEFAULT_DATE
        )
    }

}