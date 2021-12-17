package com.mirrorfiction.note.data.use_case

/**
 * Create by Neil
 * on 2021/12/15.
 */
data class NoteUseCase(
    val addNote: AddNote,
    val deleteNote: DeleteNote,
    val getNote: GetNote,
    val getNotes: GetNotes
)