package com.mirrorfiction.note.data.data_source

import androidx.room.*
import com.mirrorfiction.note.data.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * Create by Neil
 * on 2021/12/15.
 */

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}