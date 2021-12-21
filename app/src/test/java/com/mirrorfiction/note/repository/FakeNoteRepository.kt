package com.mirrorfiction.note.repository

import com.mirrorfiction.note.data.model.Note
import com.mirrorfiction.note.data.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Create by Neil
 * on 2021/12/21.
 */
class FakeNoteRepository : NoteRepository {

    private val notes = mutableListOf<Note>()

    override fun getNotes(): Flow<List<Note>> {
        return flow { emit(notes) }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return notes.find { it.id == id }
    }

    override suspend fun insertNote(note: Note) {
        notes.add(note)
    }

    override suspend fun deleteNote(note: Note) {
        notes.remove(note)
    }
}