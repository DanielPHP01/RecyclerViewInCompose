package com.example.recyclerviewincompose.presentation.ui.screen

import Navigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.recyclerviewincompose.data.local.room.NoteDatabase
import com.example.recyclerviewincompose.presentation.ui.theme.RecyclerViewInComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewInComposeTheme {
                Navigation()
            }
        }
    }
}
