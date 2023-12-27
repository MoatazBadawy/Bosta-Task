package com.moataz.bosta_task.features.photos.data.repositories

import com.moataz.bosta_task.features.photos.data.remote.PhotosService
import com.moataz.bosta_task.features.photos.data.repositories.mapper.toPhotos
import com.moataz.bosta_task.features.photos.domain.repository.PhotosRepository
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val photosRemoteService: PhotosService
) : PhotosRepository {
    override suspend fun getAlbumPhotos(albumId: Long) =
        photosRemoteService.getAlbumPhotos(albumId).toPhotos()
}