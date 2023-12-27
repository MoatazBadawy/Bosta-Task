package com.moataz.bosta_task.features.photos.domain.usecases

import com.moataz.bosta_task.features.photos.domain.repository.PhotosRepository
import javax.inject.Inject

class GetSearchPhotosByTitleUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) {
    suspend operator fun invoke(searchQuery: String, albumId: Long) =
        photosRepository.getAlbumPhotos(albumId).filter { photo ->
            photo.title.contains(searchQuery , ignoreCase = true)
        }
}