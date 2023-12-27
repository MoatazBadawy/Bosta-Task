package com.moataz.bosta_task.features.photos.ui.viewmodel

import androidx.lifecycle.SavedStateHandle

class ImageArgs(savedStateHandle: SavedStateHandle) {

    val imageUrl = savedStateHandle.get<String>(IMAGE_URL)

    companion object {
        const val IMAGE_URL = "image_url"
    }
}