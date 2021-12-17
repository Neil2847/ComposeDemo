package com.mirrorfiction.note.config.util

/**
 * Create by Neil
 * on 2021/12/15.
 */
sealed class Screen(val route: String) {
    object NoteScreen : Screen("notes_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")
}
