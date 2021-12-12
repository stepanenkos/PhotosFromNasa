package kz.stepanenkos.photosfromnasa.utils.helpers.time

import android.util.Log
import kz.stepanenkos.photosfromnasa.allDates.data.datasource.API_DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.*

object TimeHelper {

    fun getToday(): String {
        val today = Date()
        val dateFormat = SimpleDateFormat(API_DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(today.time)
    }
    fun get30DaysBeforeToday(): String {
        val today = Date()
        val dateFormat = SimpleDateFormat(API_DATE_FORMAT, Locale.getDefault())
        val calendar = GregorianCalendar()
        calendar.time = today
        calendar.add(Calendar.DAY_OF_YEAR, -30)
        return dateFormat.format(calendar.time)
    }

    fun getSpecificDay(numberOfDaysToFetch: Int = 29): String {
        val today = Date()
        val dateFormat = SimpleDateFormat(API_DATE_FORMAT, Locale.getDefault())
        val calendar: Calendar = GregorianCalendar()
        calendar.time = today
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDaysToFetch)
        Log.d("TAG", "getSpecificDay: ${calendar.time}")
        return dateFormat.format(calendar.time)
    }
}