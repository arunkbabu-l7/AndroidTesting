package com.arunkbabu.androidtesting.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arunkbabu.androidtesting.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "notes_db"
    }

    abstract fun getNoteDao(): NoteDao
}