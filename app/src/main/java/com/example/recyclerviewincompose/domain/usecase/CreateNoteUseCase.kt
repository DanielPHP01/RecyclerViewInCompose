package com.example.recyclerviewincompose.domain.usecase

import com.example.recyclerviewincompose.domain.model.NoteDomain
import com.example.recyclerviewincompose.domain.repositories.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun createNote(note: NoteDomain) = noteRepository.createNote(note)

}