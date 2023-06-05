package com.example.recyclerviewincompose.di

import android.content.Context
import androidx.room.Room
import com.example.recyclerviewincompose.data.local.room.NoteDao
import com.example.recyclerviewincompose.data.local.room.NoteDatabase
import com.example.recyclerviewincompose.data.repositories.NoteRepositoryImpl
import com.example.recyclerviewincompose.domain.repositories.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NoteModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "note_db"
    ).build()

    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }
}