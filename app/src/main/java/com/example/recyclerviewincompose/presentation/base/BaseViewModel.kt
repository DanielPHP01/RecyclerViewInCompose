package com.example.recyclerviewincompose.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewincompose.data.utils.UIState
import com.example.recyclerviewincompose.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected fun <T> Flow<Resource<T>>.collectFlow(_state: MutableStateFlow<UIState<T>>) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectFlow.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (result.data != null) {
                            _state.value = UIState.Success(result.data!!)
                        }
                    }
                    is Resource.Error -> {
                        _state.value = UIState.Error(result.message!!)
                    }
                }
            }
        }
    }
}