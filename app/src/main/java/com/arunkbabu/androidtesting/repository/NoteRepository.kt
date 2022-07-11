package com.arunkbabu.androidtesting.repository

import com.arunkbabu.androidtesting.model.Note
import com.arunkbabu.androidtesting.model.Resource
import com.arunkbabu.androidtesting.persistence.NoteDao
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(
    private val noteDao: NoteDao,
) {
    private val timeDelay = 0L
    private val timeUnit: TimeUnit = TimeUnit.SECONDS

    companion object {
        const val NOTE_TITLE_NULL = "Note title cannot be null"
        const val INVALID_NOTE_ID = "Invalid id. Can't delete note"
        const val DELETE_SUCCESS = "Delete success"
        const val DELETE_FAILURE = "Delete failure"
        const val UPDATE_SUCCESS = "Update success"
        const val UPDATE_FAILURE = "Update failure"
        const val INSERT_SUCCESS = "Insert success"
        const val INSERT_FAILURE = "Insert failure"
    }

    fun insertNote(note: Note): Flowable<Resource<out Int>> {
        checkTitle(note)

        return noteDao.insertNote(note)
            .delaySubscription(timeDelay, timeUnit)
            .map {
                return@map it.toInt()
            }
            .onErrorReturn {
                return@onErrorReturn -1
            }
            .map {
                if (it > 0) {
                    return@map Resource.Success(it, INSERT_SUCCESS)
                }
                return@map Resource.Error(null, INSERT_FAILURE)
            }
            .subscribeOn(Schedulers.io())
            .toFlowable()
    }

    private fun checkTitle(note: Note) {
        if (note.title == null)
            throw Exception(NOTE_TITLE_NULL)
    }
}