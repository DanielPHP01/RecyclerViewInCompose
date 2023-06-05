package com.example.recyclerviewincompose.data.repositories

import com.example.recyclerviewincompose.data.base.BaseRepository
import com.example.recyclerviewincompose.data.local.room.NoteDao
import com.example.recyclerviewincompose.data.mappers.toEntity
import com.example.recyclerviewincompose.data.mappers.toNote
import com.example.recyclerviewincompose.domain.model.NoteDomain
import com.example.recyclerviewincompose.domain.repositories.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao,
) : NoteRepository, BaseRepository(){
    override fun createNote(note: NoteDomain) = doRequest {
       noteDao.insert(note.toEntity())
    }

    override fun getAllNotes() = doRequest{
        noteDao.getAllNotes().map { it.toNote() }
    }
}