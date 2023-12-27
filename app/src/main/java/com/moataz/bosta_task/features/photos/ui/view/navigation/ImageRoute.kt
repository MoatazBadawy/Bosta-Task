package com.moataz.bosta_task.features.photos.ui.view.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.moataz.bosta_task.common.ui.navigation.Screen
import com.moataz.bosta_task.features.photos.ui.view.screens.ImageScreen
import com.moataz.bosta_task.features.photos.ui.viewmodel.ImageArgs
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

fun NavGraphBuilder.imageRoute(navController: NavController) {
    composable(
        route = "${Screen.Image.route}/{${ImageArgs.IMAGE_URL}}",
        arguments = listOf(
            navArgument(ImageArgs.IMAGE_URL) {
                type = NavType.StringType
            },
        )
    ) {
        ImageScreen(navController = navController)
    }
}

fun NavController.navigateToImageScreen(
    imageUrl: String
) {
    val encodedUrl = URLEncoder.encode(imageUrl, StandardCharsets.UTF_8.toString())
    navigate("${Screen.Image.route}/$encodedUrl")
}