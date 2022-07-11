package com.arunkbabu.androidtesting

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteConstraintException
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.arunkbabu.androidtesting.model.Note
import com.arunkbabu.androidtesting.util.LiveDataTestUtil
import com.arunkbabu.androidtesting.util.TestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test


class NoteDaoTest : NoteDatabaseTest() {

    companion object {
        const val TEST_TITLE = "This is a test title"
        const val TEST_CONTENT = "This is some test content"
        const val TEST_TIMESTAMP = "04-2021"
    }

    /*
     * InstantTaskExecutorRule  is for running the tests that uses a background thread
     */
    @get: Rule
    val rule = InstantTaskExecutorRule()

    /*
    * Insert, Read, Delete
    */
    @SuppressLint("CheckResult")
    @Test
    internal fun insertReadDelete() {
        val note = Note(TestUtil.TEST_NOTE_1)

        // Insert
        noteDao.insertNote(note).blockingGet() // Wait until inserted

        // Read
        var insertedNotes = LiveDataTestUtil.getValue(noteDao.getNotes())

        assertNotNull(insertedNotes)

        assertEquals(note.content, insertedNotes[0].content)
        assertEquals(note.title, insertedNotes[0].title)
        assertEquals(note.timestamp, insertedNotes[0].timestamp)

        note.id = insertedNotes[0].id
        // Verify if the inserted notes equals the expected one
        assertEquals(note, insertedNotes[0])

        // Delete
        noteDao.deleteNote(note).blockingGet()

        // Confirm the deletion; The database should be empty since we inserted only one record
        insertedNotes = LiveDataTestUtil.getValue(noteDao.getNotes())
        // Verify if the size of the list is 0 or empty
        assertEquals(0, insertedNotes.size)
    }

    /*
     * Insert, Read, Update, Read, Delete
     */
    @SuppressLint("CheckResult")
    @Test
    internal fun insertReadUpdateReadDelete() {
        val note = Note(TestUtil.TEST_NOTE_1)

        // Insert
        noteDao.insertNote(note).blockingGet() // Wait until inserted

        // Read
        var insertedNotes = LiveDataTestUtil.getValue(noteDao.getNotes())

        assertNotNull(insertedNotes)

        assertEquals(note.content, insertedNotes[0].content)
        assertEquals(note.title, insertedNotes[0].title)
        assertEquals(note.timestamp, insertedNotes[0].timestamp)

        note.id = insertedNotes[0].id
        // Verify if the inserted notes equals the expected one
        assertEquals(note, insertedNotes[0])

        // Update
        note.title = TEST_TITLE
        note.content = TEST_CONTENT
        note.timestamp = TEST_TIMESTAMP
        noteDao.updateNote(note).blockingGet()

        // Read
        insertedNotes = LiveDataTestUtil.getValue(noteDao.getNotes())
        assertEquals(TEST_TITLE, insertedNotes[0].title)
        assertEquals(TEST_CONTENT, insertedNotes[0].content)
        assertEquals(TEST_TIMESTAMP, insertedNotes[0].timestamp)

        note.id = insertedNotes[0].id
        assertEquals(note, insertedNotes[0])

        // Delete
        noteDao.deleteNote(note).blockingGet()

        // Confirm the deletion; The database should be empty since we inserted only one record
        insertedNotes = LiveDataTestUtil.getValue(noteDao.getNotes())
        // Verify if the size of the list is 0 or empty
        assertEquals(0, insertedNotes.size)
    }

    /*
     * Insert note with null title, throw exception
     */
    @Test(expected = SQLiteConstraintException::class)
    internal fun insert_nullTitle_throwSQLiteConstraintException() {
        val note = Note(TestUtil.TEST_NOTE_1)
        note.title = null

        // Insert
        noteDao.insertNote(note).blockingGet()

        // Read
        val insertedNotes = LiveDataTestUtil.getValue(noteDao.getNotes())
        if (insertedNotes[0].title == null)
            throw SQLiteConstraintException()
    }


    /*
    * Insert, Update note with null title, throw exception
    */
    @Test(expected = SQLiteConstraintException::class)
    internal fun updateNote_nullTitle_throwSQLiteConstraintException() {
        var note = Note(TestUtil.TEST_NOTE_1)

        // Insert
        noteDao.insertNote(note).blockingGet()

        // Read
        var insertedNotes = LiveDataTestUtil.getValue(noteDao.getNotes())

        // Update
        note = Note(insertedNotes[0])
        note.title = null
        noteDao.updateNote(note).blockingGet()

        // Read
        insertedNotes = LiveDataTestUtil.getValue(noteDao.getNotes())
        if (insertedNotes[0].title == null)
            throw SQLiteConstraintException()
    }
}