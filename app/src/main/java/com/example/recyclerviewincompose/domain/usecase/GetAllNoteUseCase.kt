package com.example.recyclerviewincompose.domain.usecase

import com.example.recyclerviewincompose.domain.repositories.NoteRepository
import javax.inject.Inject

class GetAllNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
){
    fun getAllNotes()= noteRepository.getAllNotes()
}