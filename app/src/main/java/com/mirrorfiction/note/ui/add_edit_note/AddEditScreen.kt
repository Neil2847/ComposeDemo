package com.mirrorfiction.note.ui.add_edit_note

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mirrorfiction.note.data.model.Note
import com.mirrorfiction.note.ui.add_edit_note.components.TransparentHintTextField
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Create by Neil
 * on 2021/12/17.
 */

@Composable
fun AddEditNoteScreen(
    naviController: NavController,
    noteColor: Int,
    viewModel: AddEditViewModel = hiltViewModel()
) {
    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value

    val scaffoldState = rememberScaffoldState()
    val noteBackgroundAnimatable = remember {
        Animatable(
            Color(if (noteColor != -1) noteColor else viewModel.noteColor.value)
        )
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is AddEditViewModel.UiEvent.SaveNote -> {
                    naviController.navigateUp()
                }
                is AddEditViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AddEditNoteEvent.SaveNote)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save note")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(noteBackgroundAnimatable.value)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Note.noteColors.forEach { color ->
                    val colorInt = color.toArgb()
                    Box(modifier = Modifier
                        .size(50.dp)
                        .shadow(15.dp, CircleShape)
                        .clip(CircleShape)
                        .background(color)
                        .border(
                            width = 3.dp,
                            color = if (viewModel.noteColor.value == colorInt) {
                                Color.Black
                            } else Color.Transparent
                        )
                        .clickable {
                            scope.launch {
                                noteBackgroundAnimatable.animateTo(
                                    targetValue = Color(colorInt),
                                    animationSpec = tween(durationMillis = 500)
                                )
                            }
                            viewModel.onEvent(AddEditNoteEvent.ChangeColor(colorInt))
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = titleState.text,
                hint = titleState.text,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                }, onFocusChange = {
                    viewModel.onEvent(AddEditNoteEvent.ChangeTitleFocus(it))
                },
                isHintVisible = titleState.isHintVisible,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = contentState.text,
                hint = contentState.text,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                }, onFocusChange = {
                    viewModel.onEvent(AddEditNoteEvent.ChangeContentFocus(it))
                },
                isHintVisible = titleState.isHintVisible,
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxHeight()
            )
        }
    }
}