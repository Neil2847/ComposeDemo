package com.mirrorfiction.note.data.repository

import com.mirrorfiction.note.data.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * Create by Neil
 * on 2021/12/15.
 */
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}