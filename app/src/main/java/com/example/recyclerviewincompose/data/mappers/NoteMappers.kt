package com.example.recyclerviewincompose.data.mappers

import com.example.recyclerviewincompose.data.local.model.NoteEntity
import com.example.recyclerviewincompose.domain.model.NoteDomain


fun NoteDomain.toEntity() = NoteEntity(id, title, desc)

fun NoteEntity.toNote() = NoteDomain(id, title, desc)