package com.mecedric.androidcomparizon.modules.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import com.mecedric.androidcomparizon.modules.main.theme.AndroidAppTheme
import com.mecedric.androidcomparizon.modules.main.theme.MaterialThemeCustom
import com.mecedric.androidcomparizon.nav.HomeTab
import com.mecedric.androidcomparizon.nav.NavActions

@Composable
fun BottomBar(
    navActions: NavActions,
    currentRoute: HomeTab = HomeTab.HOME,
) {

    if (HomeTab.values().any { it.route == currentRoute.route }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BottomNavigation(
                modifier = Modifier.navigationBarsHeight(56.dp)
            ) {
                HomeTab.values().forEach { tab ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = null,
                                tint = with(MaterialThemeCustom.colors) { if (tab.route == currentRoute.route) tabEnable else tabDisable }
                            )
                        },
                        selected = tab.route == currentRoute.route,
                        onClick = {
                            if (currentRoute == tab) {
//                                baseViewModel.listRefresh()
                            } else {
                                when (tab) {
                                    HomeTab.HOME -> navActions.navigateToHome()
                                }
                            }
                        },
                        selectedContentColor = MaterialTheme.colors.onSurface,
                        unselectedContentColor = MaterialTheme.colors.onSurface,
                        modifier = Modifier.navigationBarsPadding()
                    )
                }
            }
        }
    }
}

@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomBarPreview() {
    AndroidAppTheme {
        Surface {
            BottomBar(navActions = NavActions(rememberNavController()))
        }
    }
}