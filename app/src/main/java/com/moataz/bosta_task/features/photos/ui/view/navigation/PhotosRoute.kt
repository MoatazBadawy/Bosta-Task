package com.moataz.bosta_task.features.photos.ui.view.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.moataz.bosta_task.common.ui.navigation.Screen
import com.moataz.bosta_task.features.photos.ui.view.screens.PhotosScreen
import com.moataz.bosta_task.features.photos.ui.viewmodel.PhotosArgs

fun NavGraphBuilder.photosRoute(navController: NavController) {
    composable(
        route = "${Screen.Photos.route}/{${PhotosArgs.ALBUM_ID}}/{${PhotosArgs.ALBUM_TITLE}}",
        arguments = listOf(
            navArgument(PhotosArgs.ALBUM_ID) {
                type = NavType.LongType
            },
            navArgument(PhotosArgs.ALBUM_TITLE) {
                type = NavType.StringType
            },
        )
    ) {
        PhotosScreen(navController = navController)
    }
}

fun NavController.navigateToPhotosScreen(
    albumId: Long,
    albumTitle: String
) {
    navigate("${Screen.Photos.route}/$albumId/$albumTitle")
}