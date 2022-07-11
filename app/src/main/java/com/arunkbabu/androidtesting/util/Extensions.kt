package com.arunkbabu.androidtesting.util

val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
val monthNumbers = arrayOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12")

const val GET_MONTH_ERROR = "Error. Invalid month number."

fun String.toMonthFromNumber(): String {
    return when (this) {
        "01" -> months[0]
        "02" -> months[1]
        "03" -> months[2]
        "04" -> months[3]
        "05" -> months[4]
        "06" -> months[5]
        "07" -> months[6]
        "08" -> months[7]
        "09" -> months[8]
        "10" -> months[9]
        "11" -> months[10]
        "12" -> months[11]
        else -> GET_MONTH_ERROR
    }
}
