package com.arunkbabu.androidtesting.repository

import com.arunkbabu.androidtesting.persistence.NoteDao
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NoteRepositoryTest {

    // System Under Test
    private lateinit var noteRepository: NoteRepository

    @Mock
    private lateinit var noteDao: NoteDao

    @BeforeEach
    internal fun initEach() {
        MockitoAnnotations.initMocks(this)
        noteRepository = NoteRepository(noteDao)
    }

    @Test
    internal fun dummyTest() {
        assertNotNull(noteDao)
        assertNotNull(noteRepository)
    }
}