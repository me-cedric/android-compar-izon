package com.mecedric.androidcomparizon.modules.main.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mecedric.androidcomparizon.modules.main.theme.AndroidAppTheme
import com.mecedric.androidcomparizon.modules.main.viewmodel.MainViewModel
import com.mecedric.androidcomparizon.util.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            AndroidAppTheme {
                // change status bar color
                this@MainActivity.window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb()
                // select graph
                NavGraph(navController, viewModel)
            }
        }
    }
}