package com.example.recyclerviewincompose.objects

sealed class ScreenConstants(val route: String){
    object CreateNoteScreen : ScreenConstants("create_note__screen")
    object ListOfNoteScreen : ScreenConstants("list_of_note_screen")
}