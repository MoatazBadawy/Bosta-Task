package com.moataz.bosta_task.features.profile.ui.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.moataz.bosta_task.app.main.theme.White50
import com.moataz.bosta_task.common.ui.component.ErrorMessage
import com.moataz.bosta_task.common.ui.component.Loading
import com.moataz.bosta_task.common.ui.component.Toolbar
import com.moataz.bosta_task.features.photos.ui.view.navigation.navigateToPhotosScreen
import com.moataz.bosta_task.features.profile.ui.view.component.AlbumItem
import com.moataz.bosta_task.features.profile.ui.view.component.MyAlbumTitle
import com.moataz.bosta_task.features.profile.ui.view.component.UserInformation
import com.moataz.bosta_task.features.profile.ui.viewmodel.ProfileViewModel
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.album.AlbumUI
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.user.UserUI

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val profileUIState by viewModel.profileState.collectAsState()

    Scaffold(
        topBar = {
            Toolbar(title = "Profile")
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White50)
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            ) {
                when {
                    profileUIState.isLoading -> Loading()

                    profileUIState.isSuccessful -> ProfileContent(
                        user = profileUIState.user,
                        albums = profileUIState.albums,
                        navigateToPhotosScreen = navController::navigateToPhotosScreen
                    )

                    profileUIState.isError -> ErrorMessage()
                }
            }
        }
    )
}

@Composable
fun ProfileContent(
    user: UserUI,
    albums: List<AlbumUI>,
    navigateToPhotosScreen: (Long, String) -> Unit
) {
    Column {
        UserInformation(user = user)

        MyAlbumTitle(title = "My Albums")

        LazyColumn {
            items(albums) { album ->
                AlbumItem(
                    album,
                    onAlbumClicked = navigateToPhotosScreen
                )
            }
        }
    }
}