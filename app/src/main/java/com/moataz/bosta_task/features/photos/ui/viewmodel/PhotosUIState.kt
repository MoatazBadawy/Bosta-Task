package com.moataz.bosta_task.features.photos.ui.viewmodel

import com.moataz.bosta_task.features.photos.ui.viewmodel.model.PhotoUI

data class PhotosUIState(
    val photos: List<PhotoUI> = emptyList(),
    val isLoading: Boolean = true,
    val isSuccessful: Boolean = false,
    val isError: Boolean = false,
)
