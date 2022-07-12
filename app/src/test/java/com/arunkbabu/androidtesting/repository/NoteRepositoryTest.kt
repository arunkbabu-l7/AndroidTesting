package com.arunkbabu.androidtesting.repository

import com.arunkbabu.androidtesting.model.Note
import com.arunkbabu.androidtesting.model.Resource
import com.arunkbabu.androidtesting.persistence.NoteDao
import com.arunkbabu.androidtesting.util.TestUtil
import com.arunkbabu.androidtesting.util.any
import io.reactivex.Single
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*


class NoteRepositoryTest {

    private val note1: Note = Note(TestUtil.TEST_NOTE_1)

    // System Under Test
    private lateinit var noteRepository: NoteRepository

    private lateinit var noteDao: NoteDao

    @BeforeEach
     fun initEach() {
        noteDao = mock(NoteDao::class.java)
        noteRepository = NoteRepository(noteDao)
    }

    /*
     * Insert note
     * Verify the correct method is called
     * Confirm Observer is triggered
     * Confirm new rows inserted
     */
    @Test
    fun insertNote_returnRow() {
        // Arrange
        val insertedRow = 1L
        val returnedData: Single<Long> = Single.just(insertedRow)
        // When noteDao.insertNote is called; & any Note object is inserted; then return the 'returnedData' above
        `when`(noteDao.insertNote(any(Note::class.java))).thenReturn(returnedData)

        // Act
        val returnedValue: Resource<out Int> = noteRepository.insertNote(note1).blockingFirst()

        // Assert
        // Verify that the insertNote() is called on noteDao with any Note
        verify(noteDao).insertNote(any(Note::class.java))
        // Checks if the mock type has any more unverified interactions
        verifyNoMoreInteractions(noteDao)

        println("Returned Value: ${returnedValue.data}")
        assertEquals(Resource.Success(1, NoteRepository.INSERT_SUCCESS), returnedValue)
    }

/*    @Test
    fun insertNote_returnRow_UsingRxJavaTest() {
        // OR test using RxJava
        // The code in insertNote_returnRow() test function above can also be written as
        noteRepository.insertNote(note1)
            .test()
            .await()
            .assertValue(Resource.Success(1, NoteRepository.INSERT_SUCCESS))
    }*/

    /*
     * Insert note
     * Failure (return -1)
     */
    @Test
    fun insetNote_returnFailure() {
        // Arrange
        val failedInsert = -1L
        val returnedData: Single<Long> = Single.just(failedInsert)
        // When noteDao.insertNote is called; & any Note object is inserted; then return the 'returnedData' above
        `when`(noteDao.insertNote(any(Note::class.java))).thenReturn(returnedData)

        // Act
        val returnedValue: Resource<out Int> = noteRepository.insertNote(note1).blockingFirst()

        // Assert
        // Verify that the insertNote() is called on noteDao with any Note
        verify(noteDao).insertNote(any(Note::class.java))
        // Checks if the mock type has any more unverified interactions
        verifyNoMoreInteractions(noteDao)

        assertEquals(Resource.Error(null, NoteRepository.INSERT_FAILURE), returnedValue)
    }

    /*
     * Insert note
     * null title
     * Confirm throw exception
     */
    @Test
    fun insetNote_nullTitle_throwException() {
        assertThrows<Exception> {
            val note = Note(TestUtil.TEST_NOTE_1)
            note.title = null
            noteRepository.insertNote(note)
        }
    }
}