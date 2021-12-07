package kz.stepanenkos.photosfromnasa.utils.helpers.time

import kz.stepanenkos.photosfromnasa.allDates.data.datasource.API_DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.*

object TimeHelper {

    fun getToday(): String {
        val today = Date()
        val dateFormat = SimpleDateFormat(API_DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(today.time)
    }
}