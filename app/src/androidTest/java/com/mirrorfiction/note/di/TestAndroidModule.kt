package com.mirrorfiction.note.di

import android.app.Application
import androidx.room.Room
import com.mirrorfiction.note.data.data_source.NoteDatabase
import com.mirrorfiction.note.data.repository.NoteRepository
import com.mirrorfiction.note.data.repository.NoteRepositoryImp
import com.mirrorfiction.note.data.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Create by Neil
 * on 2021/12/21.
 */

@Module
@InstallIn(SingletonComponent::class)
object TestAndroidModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            NoteDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImp(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNotes = GetNotes(repository),
            getNote = GetNote(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}