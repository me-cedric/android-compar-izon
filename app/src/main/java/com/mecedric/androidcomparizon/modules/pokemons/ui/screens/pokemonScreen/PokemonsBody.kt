package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.pokemonScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.PokemonsEvents
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
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
    val selection = remember { mutableStateOf(1) }
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)

    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            TopAppBar(
                title = { Text("Backdrop scaffold") },
                navigationIcon = {
                    if (scaffoldState.isConcealed) {
                        IconButton(onClick = { scope.launch { scaffoldState.reveal() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Localized description")
                        }
                    } else {
                        IconButton(onClick = { scope.launch { scaffoldState.conceal() } }) {
                            Icon(Icons.Default.Close, contentDescription = "Localized description")
                        }
                    }
                },
                actions = {
                    var clickCount by remember { mutableStateOf(0) }
                    IconButton(
                        onClick = {
                            // show snackbar as a suspend function
                            scope.launch {
                                scaffoldState.snackbarHostState
                                    .showSnackbar("Snackbar #${++clickCount}")
                            }
                        }
                    ) {
                        Icon(Icons.Default.Favorite, contentDescription = "Localized description")
                    }
                },
                elevation = 0.dp,
                backgroundColor = Color.Transparent
            )
        },
        backLayerContent = {
            LazyColumn {
                items(if (selection.value >= 3) 3 else 5) {
                    ListItem(
                        Modifier.clickable {
                            selection.value = it
                            scope.launch { scaffoldState.conceal() }
                        },
                        text = { Text("Select $it") }
                    )
                }
            }
        },
        frontLayerContent = {
            Text("Selection: ${selection.value}")
            LazyColumn {
                items(50) {
                    ListItem(
                        text = { Text("Item $it") },
                        icon = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    )
                }
            }
        }
    )

//    Scaffold {
//        Column {
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
//            HorizontalPager(
//                state = pagerState,
//            ) { page ->
//                PokemonListPokemons(
//                    onEvent = onEvent,
//                    items = listPokemons
//                )
//            }
//        }
//    }
}
