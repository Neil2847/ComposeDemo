package com.mirrorfiction.note.data.use_case

import com.mirrorfiction.note.config.util.NoteOrder
import com.mirrorfiction.note.config.util.OrderType
import com.mirrorfiction.note.data.model.Note
import com.mirrorfiction.note.data.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Create by Neil
 * on 2021/12/15.
 */
class GetNotes(
    private val repository: NoteRepository
) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {

        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}