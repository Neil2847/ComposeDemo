package com.mirrorfiction.note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mirrorfiction.note.data.model.Note

/**
 * Create by Neil
 * on 2021/12/15.
 */

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "note_db"
    }
}