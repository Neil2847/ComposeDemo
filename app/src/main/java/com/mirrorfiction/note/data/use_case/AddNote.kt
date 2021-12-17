package com.mirrorfiction.note.data.use_case

import com.mirrorfiction.note.data.model.InvalidNoteException
import com.mirrorfiction.note.data.model.Note
import com.mirrorfiction.note.data.repository.NoteRepository

/**
 * Create by Neil
 * on 2021/12/15.
 */
class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }

        repository.insertNote(note)
    }
}