package com.mirrorfiction.note.ui.notes.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mirrorfiction.note.ui.theme.NoteTheme

/**
 * Create by Neil
 * on 2021/12/16.
 */

@Composable
fun DefaultRadioButton(
    text: String,
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected, onClick = onSelect,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colors.primary,
                unselectedColor = MaterialTheme.colors.onBackground
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary
        )
    }
}


@Preview(showBackground = true)

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)

@Composable
fun Show() {
    NoteTheme {
        DefaultRadioButton(text = "123", selected = false, onSelect = {})
    }
}