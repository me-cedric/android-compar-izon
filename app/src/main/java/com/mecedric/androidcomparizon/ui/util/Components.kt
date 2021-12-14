package com.mecedric.androidcomparizon.ui.util

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mecedric.androidcomparizon.R
import com.mecedric.androidcomparizon.ui.theme.titleStyle

@Composable
fun TopBar() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = stringResource(R.string.app_name),
            fontSize = 32.sp,
            color = colorResource(R.color.titleColor),
            style = titleStyle,
        )
    }
}

@ExperimentalComposeUiApi
@Composable
fun TopBarNew(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    search: () -> Unit,
    searchProgress: Boolean
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Row {
        TextField(
            placeholder = {
                Text(
                    text = "Search ...",
                    color = Color.White
                )
            },
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(50.dp)
                .border(1.dp, Color.White, RoundedCornerShape(4.dp)),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    search.invoke()
                    keyboardController?.hide()
                }),
            trailingIcon = {
                if (searchProgress) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(CenterVertically)
                            .size(20.dp),
                        strokeWidth = 3.dp,
                        color = colorResource(R.color.titleColor)
                    )
                }
            }

        )
    }

}

@Composable
fun LoadingBox() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = colorResource(R.color.titleColor),
            modifier = Modifier.size(40.dp)
        )
    }
}