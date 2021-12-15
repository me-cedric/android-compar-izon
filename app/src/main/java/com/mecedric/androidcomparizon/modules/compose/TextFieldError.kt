package com.mecedric.androidcomparizon.modules.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mecedric.androidcomparizon.modules.main.theme.AndroidAppTheme

@Composable
fun TextFieldError(
    textError: String = "Text Field Error Preview",
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = textError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            style = LocalTextStyle.current.copy(
                color = MaterialTheme.colors.error,
                fontSize = 12.sp
            )
        )
    }
}

@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTextFieldError() {
    AndroidAppTheme {
        Surface {
            TextFieldError()
        }
    }
}