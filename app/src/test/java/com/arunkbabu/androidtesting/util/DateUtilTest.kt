package com.arunkbabu.androidtesting.util

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestReporter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

class DateUtilTest {
    companion object {
        private const val today = "07-2022"
    }

    @Test
    internal fun testGetCurrentTimestamp_returnedTimestamp() {
        assertDoesNotThrow {
            assertEquals(today, DateUtil.getCurrentTimeStamp())
            println("Timestamp is generated correctly")
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    internal fun getMonthFromNumber_returnSuccess(monthNumber: Int, testInfo: TestInfo, testReporter: TestReporter) {
        assertEquals(months[monthNumber], monthNumbers[monthNumber].toMonthFromNumber())
        println("${months[monthNumber]} : ${monthNumbers[monthNumber].toMonthFromNumber()} : ${monthNumbers[monthNumber]}")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    internal fun testGetMonthFromNumber_returnError(monthNumber: Int, testInfo: TestInfo, testReporter: TestReporter) {
        val randomInt = Random(90).nextInt() + 13
        val monthNo: String = (monthNumber * randomInt).toString()
        assertEquals(monthNo.toMonthFromNumber(), GET_MONTH_ERROR)
        println("$monthNumber : ${monthNo.toMonthFromNumber()}")
    }
}