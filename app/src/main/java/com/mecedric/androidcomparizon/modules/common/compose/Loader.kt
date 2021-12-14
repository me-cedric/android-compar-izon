package com.mecedric.androidcomparizon.modules.common.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecedric.androidcomparizon.ui.theme.AndroidAppTheme

@Composable
fun Loader(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        CommonLoading(
            visibility = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoader() {
    AndroidAppTheme {
        Surface {
            Loader()
        }
    }
}