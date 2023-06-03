package com.example.recyclerviewincompose.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recyclerviewincompose.data.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<Note>
}