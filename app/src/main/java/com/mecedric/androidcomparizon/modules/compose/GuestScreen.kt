package com.mecedric.androidcomparizon.modules.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecedric.androidcomparizon.modules.main.theme.AndroidAppTheme
import com.mecedric.androidcomparizon.R

@Composable
fun GuestListScreen(
    text: String = "Long text for preview",
    painter: Painter = painterResource(id = R.drawable.ic_favorite_placeholder),
    onSignIn: () -> Unit = {},
    onSignUp: () -> Unit = {},
) {
    PlugBlock(
        text = text,
        painter = painter
    ) {
        Spacer(modifier = Modifier.size(32.dp))

        Button(
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.textButtonColors(backgroundColor = MaterialTheme.colors.secondary),
            onClick = onSignIn,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                color = MaterialTheme.colors.onSecondary,
                text = stringResource(id = R.string.common_sign_in),
            )
        }

        Spacer(modifier = Modifier.size(32.dp))

        TextButton(
            onClick = onSignUp
        ) {
            Text(stringResource(id = R.string.common_sign_up))
        }
    }
}

@ExperimentalComposeUiApi
@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GuestScreenPreview() {
    AndroidAppTheme {
        Scaffold {
            GuestListScreen()
        }
    }
}