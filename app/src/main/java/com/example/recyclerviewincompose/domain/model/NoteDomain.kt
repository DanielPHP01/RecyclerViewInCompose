package com.example.recyclerviewincompose.domain.model

data class NoteDomain(
    val id: Int = DEFAULT_ID,
    var title: String,
    var desc: String,
) {

    companion object {
        const val DEFAULT_ID = 0
    }
}
