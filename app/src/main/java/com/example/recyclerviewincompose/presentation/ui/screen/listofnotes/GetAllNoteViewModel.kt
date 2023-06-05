package com.example.recyclerviewincompose.presentation.ui.screen.listofnotes

import com.example.recyclerviewincompose.data.utils.UIState
import com.example.recyclerviewincompose.domain.model.NoteDomain
import com.example.recyclerviewincompose.domain.usecase.GetAllNoteUseCase
import com.example.recyclerviewincompose.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GetAllNoteViewModel @Inject constructor(
    private val getAllNoteUseCase: GetAllNoteUseCase,
) : BaseViewModel() {

    private val _getAllNotesUseCase = MutableStateFlow<UIState<List<NoteDomain>>>(UIState.Empty)
    val getAllNoteState = _getAllNotesUseCase.asStateFlow()

    fun getAllNotes() {
        getAllNoteUseCase.getAllNotes().collectFlow(_getAllNotesUseCase)
    }
}
