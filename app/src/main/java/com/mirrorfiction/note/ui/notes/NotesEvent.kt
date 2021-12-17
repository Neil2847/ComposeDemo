package com.mirrorfiction.note.ui.notes

import com.mirrorfiction.note.config.util.NoteOrder
import com.mirrorfiction.note.data.model.Note

/**
 * Create by Neil
 * on 2021/12/15.
 */
sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()

    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}
