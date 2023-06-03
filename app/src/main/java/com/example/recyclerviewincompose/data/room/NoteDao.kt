package com.example.recyclerviewincompose.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recyclerviewincompose.data.model.Note

@Dao
interface NoteDao {
    @Insert
     fun insert(note: Note)

    @Query("SELECT * FROM notes")
     fun getAllNotes(): List<Note>
}