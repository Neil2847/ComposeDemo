package com.mirrorfiction.note.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mirrorfiction.note.config.util.Screen
import com.mirrorfiction.note.ui.add_edit_note.AddEditNoteScreen
import com.mirrorfiction.note.ui.notes.NoteScreen
import com.mirrorfiction.note.ui.theme.NoteTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val naviController = rememberNavController()
                    NavHost(
                        navController = naviController,
                        startDestination = Screen.NoteScreen.route
                    ) {
                        composable(route = Screen.NoteScreen.route) {
                            NoteScreen(naviController = naviController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(name = "noteId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "noteColor") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(naviController = naviController, noteColor = color)
                        }
                    }
                }
            }
        }
    }
}
