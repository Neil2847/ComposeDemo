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
 * on 2021/12/15.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(context: Application): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
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
            addNote = AddNote(repository),
            deleteNote = DeleteNote(repository),
            getNote = GetNote(repository),
            getNotes = GetNotes(repository)
        )
    }
}