package com.moataz.bosta_task.features.photos.domain.usecases

import com.moataz.bosta_task.features.photos.domain.repository.PhotosRepository
import javax.inject.Inject

class GetAlbumPhotosUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) {
    suspend operator fun invoke(albumId: Long) =
        photosRepository.getAlbumPhotos(albumId)
}