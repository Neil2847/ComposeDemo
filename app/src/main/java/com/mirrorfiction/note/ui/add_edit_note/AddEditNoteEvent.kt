package com.mirrorfiction.note.ui.add_edit_note

import androidx.compose.ui.focus.FocusState

/**
 * Create by Neil
 * on 2021/12/17.
 */
sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String) : AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : AddEditNoteEvent()
    data class EnteredContent(val value: String) : AddEditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState) : AddEditNoteEvent()
    data class ChangeColor(val color: Int) : AddEditNoteEvent()

    object SaveNote : AddEditNoteEvent()
}
