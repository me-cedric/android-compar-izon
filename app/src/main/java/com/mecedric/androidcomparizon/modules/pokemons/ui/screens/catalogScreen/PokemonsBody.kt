package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.catalogScreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.PokemonsEvents
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun PokemonsBody(
    listPokemons: LazyPagingItems<Pokemon>,
    onEvent: (PokemonsEvents) -> Unit = {},
) {

    val scope = rememberCoroutineScope()
    val titles = listOf<String>(
//        stringResource(id = R.string.pokemons_tab_1),
//        stringResource(id = R.string.pokemons_tab_2)
    )

    val pagerState = rememberPagerState(pageCount = titles.size)

//    MainScaffoldSearch(
//        topBarElevation = 0.dp,
//        searchDescription = stringResource(id = R.string.common_search),
//        navigationIconDescription = stringResource(R.string.common_navigate_up),
//        contentTitle = {
//            TopBarContentTitle(stringResource(id = R.string.pokemons_title))
//        },
//        searchListener = { search ->
//            Timber.e(search)
//        },
//        closeSearchListener = {
//            Timber.e("Close")
//        }
//    ) {
    Column {
        TabRow(
            backgroundColor = MaterialTheme.colors.primary,
            selectedTabIndex = pagerState.currentPage,
            indicator = @Composable { tabPositions ->
                TabRowDefaults.Indicator(
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                )
            },
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title, color = MaterialTheme.colors.onPrimary) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }
    }
}
//}
