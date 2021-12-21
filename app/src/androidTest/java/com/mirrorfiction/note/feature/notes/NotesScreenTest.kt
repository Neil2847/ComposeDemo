package com.mirrorfiction.note.feature.notes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mirrorfiction.note.config.core.TestTags
import com.mirrorfiction.note.config.util.Screen
import com.mirrorfiction.note.di.AppModule
import com.mirrorfiction.note.ui.MainActivity
import com.mirrorfiction.note.ui.notes.NoteScreen
import com.mirrorfiction.note.ui.theme.NoteTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dalvik.annotation.TestTarget
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Create by Neil
 * on 2021/12/21.
 */

@HiltAndroidTest
@UninstallModules(AppModule::class)
class NotesScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalAnimationApi
    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            val navController = rememberNavController()
            NoteTheme {
                NavHost(navController = navController, startDestination = Screen.NoteScreen.route) {
                    composable(route = Screen.NoteScreen.route) {
                        NoteScreen(naviController = navController)
                    }
                }
            }
        }
    }

    // -----------------------------------------------
    @Test
    fun clickToggleOrderSection_isVisible() {
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertDoesNotExist()
        composeRule.onNodeWithContentDescription("Sort").performClick()
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertIsDisplayed()
    }

    // -----------------------------------------------
}