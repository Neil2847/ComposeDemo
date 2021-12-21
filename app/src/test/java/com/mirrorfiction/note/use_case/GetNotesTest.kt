package com.mirrorfiction.note.use_case

import com.google.common.truth.Truth.assertThat
import com.mirrorfiction.note.config.util.NoteOrder
import com.mirrorfiction.note.config.util.OrderType
import com.mirrorfiction.note.data.model.Note
import com.mirrorfiction.note.data.use_case.GetNotes
import com.mirrorfiction.note.repository.FakeNoteRepository
import io.mockk.InternalPlatformDsl.toStr
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Create by Neil
 * on 2021/12/21.
 */
class GetNotesTest {

    private lateinit var getNotes: GetNotes
    private lateinit var fakeNoteRepository: FakeNoteRepository

    @Before
    fun setUp() {
        fakeNoteRepository = FakeNoteRepository()
        getNotes = GetNotes(fakeNoteRepository)

        val notesToInsert = mutableListOf<Note>()
        ('a'..'z').forEachIndexed { index, c ->
            notesToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toStr(),
                    timestamp = index.toLong(),
                    color = index
                )
            )
        }

        notesToInsert.shuffle()
        runBlocking {
            notesToInsert.forEach { fakeNoteRepository.insertNote(it) }
        }
    }

    // -----------------------------------------------
    @Test
    fun `Order notes by date ascending correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Title(OrderType.Ascending)).first()

        for (i in 0..notes.size - 2) {
            assertThat(notes[i].title).isLessThan(notes[i + 1].title)
        }
    }

    // -----------------------------------------------
}