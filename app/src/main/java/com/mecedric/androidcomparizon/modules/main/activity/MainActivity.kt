package com.mecedric.androidcomparizon.modules.main.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mecedric.androidcomparizon.modules.main.theme.AndroidAppTheme
import com.mecedric.androidcomparizon.modules.main.viewmodel.MainViewModel
import com.mecedric.androidcomparizon.nav.NavGraph
import com.mecedric.androidcomparizon.util.LocalBaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalPagingApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            CompositionLocalProvider(LocalBaseViewModel provides viewModel) {
                AndroidAppTheme {
                    // change status bar color
                    this@MainActivity.window.statusBarColor =
                        MaterialTheme.colors.primaryVariant.toArgb()
                    // select graph
                    NavGraph(navController, viewModel)
                }
            }
        }
    }
}