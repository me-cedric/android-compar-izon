package com.mecedric.androidcomparizon.util

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.ButtonDefaults.textButtonColors
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState

@Composable
fun <T : Any> SwipeRefreshList(
    items: LazyPagingItems<T>,
    state: SwipeRefreshState,
    listContent: @Composable LazyListScope.(index: Int, data: T) -> Unit,
) {

    SwipeRefresh(
        state = state,
        onRefresh = { items.refresh() }
    ) {

        state.isRefreshing =
            items.loadState.refresh is LoadState.Loading

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),

            ) {
            itemsIndexed(items) { index, data ->
                if (data != null) {
                    this@LazyColumn.listContent(index, data)
                }
            }
            items.apply {
                when {
                    loadState.append is LoadState.Loading -> {
                        //Charger plus,En basloading
                        item { LoadingItem() }
                    }
                    loadState.append is LoadState.Error -> {
                        // Charger plus d'exceptions
                        item {
                            ErrorMoreRetryItem() {
                                items.retry()
                            }
                        }
                    }
                    loadState.refresh is LoadState.Error -> {
                        if (items.itemCount <= 0) {
                            //Quand on se rafraîchit,SiitemCountMoins de0, Exception à la première charge
                            item {
                                ErrorContent() {
                                    items.retry()
                                }
                            }
                        } else {
                            item {
                                ErrorMoreRetryItem() {
                                    items.retry()
                                }
                            }
                        }
                    }
                    loadState.refresh is LoadState.Loading -> {
                        //  Premier chargement et chargement en cours
                        if (items.itemCount == 0) {
                        }
                    }
                }
            }

        }
    }
}

/** *  Chargement en bas plus de traitement des défaillances  * */
@Composable
fun ErrorMoreRetryItem(retry: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        TextButton(
            onClick = { retry() },
            modifier = Modifier
                .padding(20.dp)
                .width(80.dp)
                .height(30.dp),
            shape = RoundedCornerShape(6.dp),
            contentPadding = PaddingValues(3.dp),
            colors = textButtonColors(backgroundColor = MaterialTheme.colors.primary),
            elevation = elevation(
                defaultElevation = 2.dp,
                pressedElevation = 4.dp,
            ),
        ) {
            Text(text = "Veuillez réessayer.", color = MaterialTheme.colors.primary)
        }
    }
}

/** *  Traitement de l'échec du chargement de la page  * */
@Composable
fun ErrorContent(retry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Image(
//            modifier = Modifier.padding(top = 80.dp),
//            painter = painterResource(id = R.drawable.ic_default_empty),
//            contentDescription = null
//        )
        Text(
            text = "La demande a échoué,Veuillez vérifier le réseau",
            modifier = Modifier.padding(8.dp)
        )
        TextButton(
            onClick = { retry() },
            modifier = Modifier
                .padding(20.dp)
                .width(80.dp)
                .height(30.dp),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(5.dp),
            colors = textButtonColors(backgroundColor = MaterialTheme.colors.primary),
            elevation = elevation(
                defaultElevation = 2.dp,
                pressedElevation = 4.dp,
            )
            //colors = ButtonDefaults
        ) { Text(text = "Retry", color = MaterialTheme.colors.primary) }
    }
}

/** *  Chargement en bas plus de chargement en cours ... * */
@Composable
fun LoadingItem() {
    Row(
        modifier = Modifier
            .height(34.dp)
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(24.dp),
            color = MaterialTheme.colors.primary,
            strokeWidth = 2.dp
        )
        Text(
            text = "Chargement...",
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 20.dp),
            fontSize = 18.sp,
        )
    }
}