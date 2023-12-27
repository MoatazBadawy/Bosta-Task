package com.moataz.bosta_task.common.ui.navigation

sealed class Screen(val route: String) {
    data object Profile : Screen("profile")
    data object Photos : Screen("album_photos")
}