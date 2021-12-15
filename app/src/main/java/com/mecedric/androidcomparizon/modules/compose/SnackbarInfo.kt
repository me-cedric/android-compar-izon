package com.mecedric.androidcomparizon.modules.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mecedric.androidcomparizon.R

@Composable
fun SnackbarInfo(
    modifier: Modifier = Modifier,
) {
    Snackbar(
        modifier = modifier.padding(8.dp)
    ) {
        Text(text = stringResource(id = R.string.common_exit))
    }
}