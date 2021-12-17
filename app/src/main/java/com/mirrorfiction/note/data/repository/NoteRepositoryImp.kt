package com.mirrorfiction.note.data.repository

import com.mirrorfiction.note.data.data_source.NoteDao
import com.mirrorfiction.note.data.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * Create by Neil
 * on 2021/12/15.
 */

class NoteRepositoryImp(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}