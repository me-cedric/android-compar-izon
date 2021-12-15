package com.mecedric.androidcomparizon.modules.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalMaterialApi
@Composable
fun BottomSheetScaffoldInfo(
    isShow: Boolean = false,
    height: Dp = 350.dp,
    content: @Composable ColumnScope.(BottomSheetScaffoldState) -> Unit,
) {
    rememberSystemUiController().setStatusBarColor(
        color = if (isShow) Color.Black.copy(alpha = 0.7f) else MaterialTheme.colors.primaryVariant
    )

    if (isShow) {
        val state = rememberBottomSheetScaffoldState(
            bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
        )
        BottomSheetScaffold(
            sheetGesturesEnabled = false,
            sheetBackgroundColor = Color.Transparent,
            backgroundColor = Color.Black.copy(alpha = 0.7f),
            scaffoldState = state,
            sheetPeekHeight = 0.dp,
            sheetElevation = 0.dp,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = height)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colors.background)
                            .align(Alignment.BottomStart)
                    ) {
                        content.invoke(this, state)
                    }
                }
            }
        ) {}

        LaunchedEffect(isShow) {
            if (state.bottomSheetState.isCollapsed) {
                state.bottomSheetState.expand()
            } else {
                state.bottomSheetState.collapse()
            }
        }
    }
}