package com.mirrorfiction.note.data.use_case

import com.mirrorfiction.note.data.model.Note
import com.mirrorfiction.note.data.repository.NoteRepository

/**
 * Create by Neil
 * on 2021/12/15.
 */
class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}