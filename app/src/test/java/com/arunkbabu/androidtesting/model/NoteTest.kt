package com.arunkbabu.androidtesting.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class NoteTest {
    companion object {
        private const val TIMESTAMP_1 = "05-2022"
        private const val TIMESTAMP_2 = "04-2022"
    }

    @Test
    internal fun isNotesEqual_identicalProperties_returnTrue() {
        // Arrange
        val note1 = Note(1, "Note #1", "This is a note #1", TIMESTAMP_1)
        val note2 = Note(1, "Note #1", "This is a note #1", TIMESTAMP_1)

        // Act

        // Assert
        assertEquals(note1, note2)
        // If the above assertion fails then it won't reach this line
        println("The notes are equal")
    }

    @Test
    internal fun isNotesEqual_differentIds_returnFalse() {
        // Arrange
        val note1 = Note(1, "Note #1", "This is a note #1", TIMESTAMP_1)
        val note2 = Note(2, "Note #1", "This is a note #1", TIMESTAMP_1)

        // Act

        // Assert
        assertNotEquals(note1, note2)
        // If the above assertion fails then it won't reach this line
        println("The notes are not equal")
    }

    @Test
    internal fun isNotesEqual_differentTimestamps_returnTrue() {
        // Arrange
        val note1 = Note(1, "Note #1", "This is a note #1", TIMESTAMP_1)
        val note2 = Note(1, "Note #1", "This is a note #1", TIMESTAMP_2)

        // Act

        // Assert
        assertEquals(note1, note2)
        // If the above assertion fails then it won't reach this line
        println("The notes are equal")
    }

    @Test
    internal fun isNotesEqual_differentTitle_returnFalse() {
        // Arrange
        val note1 = Note(1, "Note #1", "This is a note #1", TIMESTAMP_1)
        val note2 = Note(1, "Note #2", "This is a note #1", TIMESTAMP_1)

        // Act

        // Assert
        assertNotEquals(note1, note2)
        // If the above assertion fails then it won't reach this line
        println("The notes are not equal! They have different titles")
    }

    @Test
    internal fun isNotesEqual_differentContent_returnFalse() {
        // Arrange
        val note1 = Note(1, "Note #1", "This is a note #1", TIMESTAMP_1)
        val note2 = Note(1, "Note #1", "This is a note #2", TIMESTAMP_1)

        // Act

        // Assert
        assertNotEquals(note1, note2)
        // If the above assertion fails then it won't reach this line
        println("The notes are not equal! They have different content")
    }
}

