package com.example.recyclerviewincompose.presentation.ui.screen.createnote

import com.example.recyclerviewincompose.data.utils.UIState
import com.example.recyclerviewincompose.domain.model.NoteDomain
import com.example.recyclerviewincompose.domain.usecase.CreateNoteUseCase
import com.example.recyclerviewincompose.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
@HiltViewModel
class CreateNoteViewModel @Inject constructor (
    private val createNoteUseCase: CreateNoteUseCase
): BaseViewModel(){

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty)

    fun createNote(note: NoteDomain) {
        createNoteUseCase.createNote(note).collectFlow(_createNoteState)
    }
}