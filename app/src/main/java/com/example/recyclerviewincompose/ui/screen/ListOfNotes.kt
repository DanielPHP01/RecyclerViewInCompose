package com.example.recyclerviewincompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recyclerviewincompose.data.Note

@Composable
fun ListOfNotesScreen(data: ArrayList<Note> = arrayListOf<Note>()) {

    LazyColumn() {
        items(data) {
            NoteItem(item = it)
        }
    }
}

@Composable
fun NoteItem(item:Note) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = item.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = item.desc, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}