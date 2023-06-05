package com.example.recyclerviewincompose.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recyclerviewincompose.data.local.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
