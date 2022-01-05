package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.detailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.DetailsEvents

@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun DetailsBody(
    listDetails: LazyPagingItems<Pokemon>,
    onEvent: (DetailsEvents) -> Unit = {},
) {

    val scope = rememberCoroutineScope()
    val titles = listOf<String>(
//        stringResource(id = R.string.pokemons_tab_1),
//        stringResource(id = R.string.pokemons_tab_2)
    )

    val pagerState = rememberPagerState(pageCount = titles.size)

    Scaffold {
        Column {
//            TabRow(
//                backgroundColor = MaterialTheme.colors.primary,
//                selectedTabIndex = pagerState.currentPage,
//                indicator = @Composable { tabPositions ->
//                    TabRowDefaults.Indicator(
//                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
//                        modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
//                    )
//                },
//            ) {
//                titles.forEachIndexed { index, title ->
//                    Tab(
//                        text = { Text(text = title, color = MaterialTheme.colors.onPrimary) },
//                        selected = pagerState.currentPage == index,
//                        onClick = {
//                            scope.launch {
//                                pagerState.animateScrollToPage(index)
//                            }
//                        }
//                    )
//                }
//            }
            HorizontalPager(
                state = pagerState,
            ) { page ->
//                PokemonListPokemons(
//                    onEvent = onEvent,
//                    items = listPokemons
//                )
            }
        }
    }
}
