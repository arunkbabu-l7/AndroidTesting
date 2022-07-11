package com.arunkbabu.androidtesting

import android.os.Bundle
import android.util.Log
import com.arunkbabu.androidtesting.repository.NoteRepository
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject lateinit var noteRepository: NoteRepository
    private val tag = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(tag, "onCreate: $noteRepository")
    }
}