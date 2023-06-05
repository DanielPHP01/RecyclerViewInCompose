package com.example.recyclerviewincompose.domain.repositories

import com.example.recyclerviewincompose.domain.model.NoteDomain
import com.example.recyclerviewincompose.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: NoteDomain): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<NoteDomain>>>
}