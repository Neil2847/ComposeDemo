package com.mirrorfiction.note.ui.add_edit_note.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.mirrorfiction.note.ui.theme.NoteTheme

/**
 * Create by Neil
 * on 2021/12/17.
 */

@Composable
fun TransparentHintTextField(
    modifier: Modifier = Modifier,
    text: String,
    hint: String,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { onFocusChange(it) }
        )
        if (isHintVisible) {
            Text(text = hint, style = textStyle, color = MaterialTheme.colors.primary)
        }
    }
}

@Preview(showBackground = true)

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)

@Composable
fun ShowTextField() {
    NoteTheme {
        TransparentHintTextField(
            text = "",
            hint = "please enter password",
            onValueChange = {},
            onFocusChange = {})
    }
}