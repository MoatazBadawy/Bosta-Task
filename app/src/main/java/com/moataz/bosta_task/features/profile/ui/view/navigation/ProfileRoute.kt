package com.moataz.bosta_task.features.profile.ui.view.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.moataz.bosta_task.common.ui.navigation.Screen
import com.moataz.bosta_task.features.profile.ui.view.screens.ProfileScreen

fun NavGraphBuilder.profileRoute(navController: NavController) {
    composable(
        route = Screen.Profile.route,
        content = {
            ProfileScreen(
                navController = navController,
            )
        },
    )
}