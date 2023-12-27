package com.moataz.bosta_task.features.photos.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moataz.bosta_task.app.di.utils.IoDispatcher
import com.moataz.bosta_task.features.photos.domain.usecases.GetAlbumPhotosUseCase
import com.moataz.bosta_task.features.photos.domain.usecases.GetSearchPhotosByTitleUseCase
import com.moataz.bosta_task.features.photos.ui.viewmodel.mapper.toPhotosUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getAlbumPhotosUseCase: GetAlbumPhotosUseCase,
    private val getSearchPhotosByTitleUseCase: GetSearchPhotosByTitleUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    state: SavedStateHandle,
) : ViewModel() {

    private var _photosArgs = PhotosArgs(state)

    private val _albumTitle = MutableStateFlow("")
    val albumTitle get() = _albumTitle.asStateFlow()

    private val _photosState = MutableStateFlow(PhotosUIState())
    val photosState get() = _photosState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery get() = _searchQuery.asStateFlow()

    private var searchJob: Job? = null

    init {
        initAlbumTitle()
        getAlbumPhotos()
    }

    fun setSearchQuery(searchQuery: String) {
        _searchQuery.value = searchQuery
    }

    private fun initAlbumTitle() {
        _albumTitle.value = _photosArgs.albumTitle ?: ""
    }

    private fun getAlbumId() = _photosArgs.albumId ?: 0

    private fun getAlbumPhotos() {
        viewModelScope.launch(ioDispatcher) {
            try {
                _photosState.update { photosUIState ->
                    photosUIState.copy(
                        photos = getAlbumPhotosUseCase(
                            getAlbumId()
                        ).toPhotosUI(),
                        isSuccessful = true,
                        isLoading = false,
                        isError = false,
                    )

                }
            } catch (e: Exception) {
                _photosState.value = PhotosUIState(
                    photos = emptyList(),
                    isLoading = false,
                    isSuccessful = false,
                    isError = true,
                )
            }
        }
    }

    fun searchPhotosByTitle() {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(ioDispatcher) {
            delay(300L)
            try {
                _photosState.update { photosUIState ->
                    photosUIState.copy(
                        photos = getSearchPhotosByTitleUseCase(
                            _searchQuery.value,
                            getAlbumId()
                        ).toPhotosUI(),
                        isSuccessful = true,
                        isLoading = false,
                        isError = false,
                    )

                }
            } catch (e: Exception) {
                _photosState.value = PhotosUIState(
                    photos = emptyList(),
                    isLoading = false,
                    isSuccessful = false,
                    isError = true,
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        searchJob?.cancel()
    }
}