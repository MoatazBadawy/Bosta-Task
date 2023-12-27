package com.moataz.bosta_task.app.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.moataz.bosta_task.app.main.theme.BostaTaskTheme
import com.moataz.bosta_task.common.ui.navigation.MainNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BostaTaskTheme {
                MainNavGraph()
            }
        }
    }
}