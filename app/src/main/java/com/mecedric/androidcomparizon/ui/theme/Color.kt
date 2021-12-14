package com.mecedric.androidcomparizon.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.mecedric.androidcomparizon.R

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


class CustomColors(
    val splash: Color,
    val customTitle: Color,
    val tabEnable: Color,
    val tabDisable: Color,
    val textColorSecondary: Color,
    val isLight: Boolean,
)

@Composable
fun parseConfigCustomPalette(isLight: Boolean): CustomColors {
    return CustomColors(
        splash = colorResource(R.color.splash),
        customTitle = colorResource(R.color.customTitle),
        tabEnable = colorResource(R.color.tabEnable),
        tabDisable = colorResource(R.color.tabDisable),
        textColorSecondary = colorResource(R.color.textColorSecondary),
        isLight = isLight,
    )
}

@Composable
fun parseConfigPalette(isLight: Boolean): Colors {
    return Colors(
        primary = colorResource(R.color.primary),
        primaryVariant = colorResource(R.color.primaryVariant),
        secondary = colorResource(R.color.secondary),
        secondaryVariant = colorResource(R.color.secondaryVariant),
        background = colorResource(R.color.background),
        surface = colorResource(R.color.surface),
        error = colorResource(R.color.error),
        onPrimary = colorResource(R.color.onPrimary),
        onSecondary = colorResource(R.color.onSecondary),
        onBackground = colorResource(R.color.onBackground),
        onSurface = colorResource(R.color.onSurface),
        onError = colorResource(R.color.onError),
        isLight = isLight,
    )
}

@Composable
fun customTextFieldColors(
    textColor: Color = LocalContentColor.current.copy(LocalContentAlpha.current),
    disabledTextColor: Color = textColor.copy(ContentAlpha.disabled),
    backgroundColor: Color = MaterialTheme.colors.onSurface.copy(alpha = TextFieldDefaults.BackgroundOpacity),
    cursorColor: Color = MaterialTheme.colors.onPrimary,
    errorCursorColor: Color = MaterialTheme.colors.error,
    focusedIndicatorColor: Color = MaterialTheme.colors.onPrimary.copy(alpha = ContentAlpha.high),
    unfocusedIndicatorColor: Color = MaterialTheme.colors.onSurface.copy(alpha = TextFieldDefaults.UnfocusedIndicatorLineOpacity),
    disabledIndicatorColor: Color = unfocusedIndicatorColor.copy(alpha = ContentAlpha.disabled),
    errorIndicatorColor: Color = MaterialTheme.colors.error,
    leadingIconColor: Color = MaterialTheme.colors.onSurface.copy(alpha = TextFieldDefaults.IconOpacity),
    disabledLeadingIconColor: Color = leadingIconColor.copy(alpha = ContentAlpha.disabled),
    errorLeadingIconColor: Color = leadingIconColor,
    trailingIconColor: Color = MaterialTheme.colors.onSurface.copy(alpha = TextFieldDefaults.IconOpacity),
    disabledTrailingIconColor: Color = trailingIconColor.copy(alpha = ContentAlpha.disabled),
    errorTrailingIconColor: Color = MaterialTheme.colors.error,
    focusedLabelColor: Color = MaterialTheme.colors.onPrimary.copy(alpha = ContentAlpha.high),
    unfocusedLabelColor: Color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),
    disabledLabelColor: Color = unfocusedLabelColor.copy(ContentAlpha.disabled),
    errorLabelColor: Color = MaterialTheme.colors.error,
    placeholderColor: Color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),
    disabledPlaceholderColor: Color = placeholderColor.copy(ContentAlpha.disabled),
): TextFieldColors =
    TextFieldDefaults.textFieldColors(
        textColor = textColor,
        disabledTextColor = disabledTextColor,
        cursorColor = cursorColor,
        errorCursorColor = errorCursorColor,
        focusedIndicatorColor = focusedIndicatorColor,
        unfocusedIndicatorColor = unfocusedIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,
        leadingIconColor = leadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        trailingIconColor = trailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
        backgroundColor = backgroundColor,
        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,
        placeholderColor = placeholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor
    )