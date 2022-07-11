package com.arunkbabu.androidtesting.util

import com.arunkbabu.androidtesting.model.Note

object TestUtil {

    const val TIMESTAMP_1 = "06-2022"
    val TEST_NOTE_1 = Note("Take out the trash", "It's garbage day tomorrow.", TIMESTAMP_1)

    const val TIMESTAMP_2 = "07-2022"
    val TEST_NOTE_2 = Note("Anniversary gift", "Buy an anniversary gift.", TIMESTAMP_2)

    val TEST_NOTES_LIST: List<Note> = listOf(
        Note(1, "Take out the trash", "It's garbage day tomorrow.", TIMESTAMP_1),
        Note(2, "Anniversary gift", "Buy an anniversary gift.", TIMESTAMP_2)
    )
}