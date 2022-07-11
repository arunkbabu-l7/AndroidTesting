package com.arunkbabu.androidtesting.util

import java.text.SimpleDateFormat
import java.util.Date

object DateUtil {
    const val DATE_FORMAT = "MM-yyyy"

    @Throws(Exception::class)
    fun getCurrentTimeStamp(): String {
        return try {
            val dateFormat = SimpleDateFormat(DATE_FORMAT) //MUST USE LOWERCASE 'y'. API 23- can't use uppercase
            dateFormat.format(Date()) // Find todays date
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Couldn't format the date into MM-yyyy")
        }
    }
}