package com.arunkbabu.androidtesting.di

import android.app.Application
import androidx.room.Room
import com.arunkbabu.androidtesting.persistence.NoteDao
import com.arunkbabu.androidtesting.persistence.NoteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(application: Application): NoteDatabase = Room.databaseBuilder(
        application,
        NoteDatabase::class.java,
        NoteDatabase.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.getNoteDao()


    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao) =
        NoteRepository1(noteDao)
}