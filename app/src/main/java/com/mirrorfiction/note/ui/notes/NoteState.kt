package com.mirrorfiction.note.ui.notes

import com.mirrorfiction.note.config.util.NoteOrder
import com.mirrorfiction.note.config.util.OrderType
import com.mirrorfiction.note.data.model.Note

/**
 * Create by Neil
 * on 2021/12/15.
 */
data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
