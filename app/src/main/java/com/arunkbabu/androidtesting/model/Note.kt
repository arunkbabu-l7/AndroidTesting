package com.arunkbabu.androidtesting.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "notes")
data class Note(
    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "content")
    var content: String = "",

    @ColumnInfo(name = "timestamp")
    var timestamp: String = "",
) : Parcelable {

    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @Ignore
    constructor(id: Int, @NonNull title: String, content: String, timestamp: String) : this(title, content, timestamp) {
        this.id = id
    }

    @Ignore
    constructor(note: Note) : this() {
        this.id = note.id
        this.title = note.title
        this.content = note.content
        this.timestamp = note.timestamp
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }

        if (javaClass != other.javaClass) {
            return false
        }

        val note = other as Note
        return note.id == id && note.title == title && note.content == content
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + timestamp.hashCode()
        result = 31 * result + id
        return result
    }
}
