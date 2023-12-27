package com.moataz.bosta_task.features.photos.ui.viewmodel

import androidx.lifecycle.SavedStateHandle

class PhotosArgs(savedStateHandle: SavedStateHandle) {

    val albumId = savedStateHandle.get<Long>(ALBUM_ID)
    val albumTitle = savedStateHandle.get<String>(ALBUM_TITLE)

    companion object {
        const val ALBUM_ID = "album_id"
        const val ALBUM_TITLE = "album_title"
    }
}