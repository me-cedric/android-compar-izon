package com.mecedric.androidcomparizon.modules.home.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mecedric.androidcomparizon.R
import com.mecedric.androidcomparizon.modules.common.compose.EmptyListScreen
import com.mecedric.androidcomparizon.modules.common.compose.TopBarContentSubtitle
import com.mecedric.androidcomparizon.modules.common.compose.TopBarContentTitle
import com.mecedric.androidcomparizon.modules.home.ui.events.HomeEvents
import com.mecedric.androidcomparizon.modules.home.ui.viewModels.HomeViewModel
import com.mecedric.androidcomparizon.ui.theme.AndroidAppTheme

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
    MainScaffoldSearch(
        contentTitle = {
            TopBarContentTitle(stringResource(id = R.string.cart_title).uppercase(), TextAlign.Center)
            Spacer(modifier = Modifier.sizeXSmall())
            TopBarContentSubtitle(stringResource(id = R.string.cart_subtitle, (12345678..87654321).random()))
        },
    ) {
        EmptyListScreen(
            title = stringResource(id = R.string.cart_empty_title),
            text = stringResource(id = R.string.cart_empty_text),
            painter = painterResource(id = R.drawable.ic_cart_empty_state)
        )
    }
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