package com.arunkbabu.androidtesting

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.arunkbabu.androidtesting.persistence.NoteDao
import com.arunkbabu.androidtesting.persistence.NoteDatabase
import org.junit.After
import org.junit.Before

abstract class NoteDatabaseTest {
    private lateinit var noteDatabase: NoteDatabase

    internal fun getNoteDao(): NoteDao {
        return noteDatabase.getNoteDao()
    }

    @Before
    internal fun init() {
        noteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).build()
    }

    @After
    internal fun finish() {
        noteDatabase.close()
    }
}