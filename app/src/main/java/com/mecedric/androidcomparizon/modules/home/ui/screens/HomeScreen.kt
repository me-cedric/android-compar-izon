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
import com.keygenqt.accompanist.MainScaffoldSearch
import com.keygenqt.demo_contacts.R
import com.keygenqt.demo_contacts.modules._common.ui.compose.EmptyListScreen
import com.keygenqt.demo_contacts.modules._common.ui.compose.TopBarContentSubtitle
import com.keygenqt.demo_contacts.modules._common.ui.compose.TopBarContentTitle
import com.mecedric.androidcomparizon.modules.home.ui.events.HomeEvents
import com.mecedric.androidcomparizon.modules.home.ui.viewModels.HomeViewModel
import com.keygenqt.demo_contacts.theme.MyTheme
import com.keygenqt.modifier.sizeXSmall

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
    MyTheme {
        Scaffold {
            CartBody()
        }
    }
}