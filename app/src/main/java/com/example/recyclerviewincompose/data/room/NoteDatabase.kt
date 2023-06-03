package com.example.recyclerviewincompose.data.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recyclerviewincompose.data.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
