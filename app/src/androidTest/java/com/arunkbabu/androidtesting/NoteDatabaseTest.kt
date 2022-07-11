package com.arunkbabu.androidtesting

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arunkbabu.androidtesting.persistence.NoteDao
import com.arunkbabu.androidtesting.persistence.NoteDatabase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class NoteDatabaseTest {
    private lateinit var noteDatabase: NoteDatabase
    lateinit var noteDao: NoteDao
        private set

    @Before
    internal fun init() {
        noteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).build()

        noteDao = noteDatabase.getNoteDao()
    }

    @After
    internal fun finish() {
        noteDatabase.close()
    }
}