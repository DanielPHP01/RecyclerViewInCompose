package com.example.recyclerviewincompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.recyclerviewincompose.data.model.Note
import com.example.recyclerviewincompose.data.room.NoteDatabase
import com.example.recyclerviewincompose.ui.theme.TextFieldColorPlaceHolder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNoteScreen(
    navigationListOfNote: () -> Unit,
    db: NoteDatabase
) {

    var titleText by remember {
        mutableStateOf("")
    }
    var descText by remember {
        mutableStateOf("")
    }

    val onNoteSaved: () -> Unit = {
        db.noteDao().insert(Note(title = titleText, desc = descText))
        navigationListOfNote.invoke()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TextField(
            value = titleText,
            onValueChange = { titleText = it },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            placeholder = {
                Text(
                    text = "Name",
                    color = TextFieldColorPlaceHolder
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
        )
        TextField(
            value = descText,
            onValueChange = { descText = it },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            placeholder = {
                Text(
                    text = "Name",
                    color = TextFieldColorPlaceHolder
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
        )
        Button(onClick = { onNoteSaved.invoke() }) {
            Text(text = "Save Note")
        }
    }
}