package com.moataz.bosta_task.common.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.moataz.bosta_task.features.photos.ui.view.navigation.imageRoute
import com.moataz.bosta_task.features.photos.ui.view.navigation.photosRoute
import com.moataz.bosta_task.features.profile.ui.view.navigation.profileRoute

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Profile.route
    ) {
        profileRoute(navController = navController)
        photosRoute(navController = navController)
        imageRoute(navController = navController)
    }
}