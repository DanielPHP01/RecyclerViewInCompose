package com.example.recyclerviewincompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.recyclerviewincompose.data.room.NoteDatabase
import com.example.recyclerviewincompose.objects.ScreenConstants
import com.example.recyclerviewincompose.ui.screen.CreateNoteScreen
import com.example.recyclerviewincompose.ui.screen.ListOfNotesScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val context = LocalContext.current
    val db =
        Room.databaseBuilder(context, NoteDatabase::class.java, "notes-db").allowMainThreadQueries()
            .build()


    NavHost(
        navController = navController,
        startDestination = ScreenConstants.CreateNoteScreen.route
    ) {
        composable(ScreenConstants.CreateNoteScreen.route) {
            CreateNoteScreen(
                navigationListOfNote = { navController.navigate(ScreenConstants.ListOfNoteScreen.route) },
                db = db
            )
        }
        composable(ScreenConstants.ListOfNoteScreen.route) {
            ListOfNotesScreen(database = db)
        }
    }
}
