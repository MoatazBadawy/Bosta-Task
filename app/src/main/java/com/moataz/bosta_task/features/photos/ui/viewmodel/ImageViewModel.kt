package com.moataz.bosta_task.features.photos.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    state: SavedStateHandle,
) : ViewModel() {

    private val _imageArgs = ImageArgs(state)

    private val _imageUrl = MutableStateFlow("")
    val imageUrl get() = _imageUrl.asStateFlow()

    init {
        initNavArgs()
    }

    private fun initNavArgs() {
        _imageUrl.value = _imageArgs.imageUrl ?: ""
    }
}