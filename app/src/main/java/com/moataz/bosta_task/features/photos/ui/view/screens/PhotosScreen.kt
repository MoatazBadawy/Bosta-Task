package com.moataz.bosta_task.features.photos.ui.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moataz.bosta_task.app.main.theme.White50
import com.moataz.bosta_task.common.ui.component.ErrorMessage
import com.moataz.bosta_task.common.ui.component.Loading
import com.moataz.bosta_task.common.ui.component.Toolbar
import com.moataz.bosta_task.features.photos.ui.view.component.PhotoItem
import com.moataz.bosta_task.features.photos.ui.view.component.SearchView
import com.moataz.bosta_task.features.photos.ui.viewmodel.PhotosViewModel
import com.moataz.bosta_task.features.photos.ui.viewmodel.model.PhotoUI

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PhotosScreen(
    viewModel: PhotosViewModel = hiltViewModel()
) {
    val photosUIState by viewModel.photosState.collectAsState()
    val albumTitle by viewModel.albumTitle.collectAsState()

    Scaffold(
        topBar = {
            Toolbar(title = albumTitle)
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White50)
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            ) {
                when {
                    photosUIState.isLoading -> Loading()

                    photosUIState.isSuccessful -> PhotosContent(
                        photos = photosUIState.photos,
                        viewModel = viewModel
                    )

                    photosUIState.isError -> ErrorMessage()
                }
            }
        }
    )
}

@Composable
fun PhotosContent(
    photos: List<PhotoUI>,
    viewModel: PhotosViewModel
) {
    Column {
        SearchView(viewModel = viewModel)

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(0.dp)
        ) {
            items(photos) { photo ->
                PhotoItem(photo = photo)
            }
        }
    }
}