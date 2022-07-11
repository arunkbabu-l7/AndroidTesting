package com.arunkbabu.androidtesting.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arunkbabu.androidtesting.model.Note
import io.reactivex.Single
import kotlin.jvm.Throws

@Dao
interface NoteDao {

    @Insert
    @Throws(Exception::class)
    fun insertNote(note: Note): Single<Long>

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Note>>

    @Delete
    @Throws(Exception::class)
    fun deleteNote(note: Note): Single<Int>

    @Update
    @Throws(Exception::class)
    fun updateNote(note: Note): Single<Int>
}