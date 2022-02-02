package com.mecedric.androidcomparizon.util

import android.util.Log
import androidx.compose.runtime.staticCompositionLocalOf
import com.mecedric.androidcomparizon.modules.main.viewmodel.MainViewModel

val LocalBaseViewModel = staticCompositionLocalOf<MainViewModel> {
    Log.e("TAG", "LocalBaseViewModel: No MainViewModel found!")
    error("No MainViewModel found!")
}