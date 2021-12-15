package com.mecedric.androidcomparizon.modules.home.ui.screens

import android.content.res.Configuration
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mecedric.androidcomparizon.R
import com.mecedric.androidcomparizon.modules.compose.EmptyListScreen
import com.mecedric.androidcomparizon.modules.home.ui.events.HomeEvents
import com.mecedric.androidcomparizon.modules.home.ui.viewModels.HomeViewModel
import com.mecedric.androidcomparizon.modules.main.theme.AndroidAppTheme

@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onEvent: (HomeEvents) -> Unit = {},
) {
    HomeBody(
        onEvent = onEvent,
    )
}

@ExperimentalComposeUiApi
@Composable
fun HomeBody(
    onEvent: (HomeEvents) -> Unit = {},
) {
    EmptyListScreen(
        title = stringResource(id = R.string.app_name),
        text = stringResource(id = R.string.app_name),
        painter = painterResource(id = R.drawable.ic_cart_empty_state)
    )
}

@ExperimentalComposeUiApi
@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EmptyListScreenPreview() {
    AndroidAppTheme() {
        Scaffold {
            HomeBody()
        }
    }
}