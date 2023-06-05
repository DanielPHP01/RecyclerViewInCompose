package com.example.recyclerviewincompose.data.base

import com.example.recyclerviewincompose.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    protected fun <T> doRequest(request:suspend () -> T ) = flow{
        emit(Resource.Loading())
        try {
            val data = request()
            emit(Resource.Success(data))
        } catch (e:Exception) {
            emit(Resource.Error(e.localizedMessage ?: "g"))
        }
    }.flowOn(Dispatchers.IO)
}