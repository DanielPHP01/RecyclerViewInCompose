package com.example.recyclerviewincompose.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recyclerviewincompose.data.local.model.NoteEntity

@Dao
interface NoteDao {
    @Insert
     fun insert(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
     fun getAllNotes(): List<NoteEntity>
}