package com.moataz.bosta_task.features.photos.domain.repository

import com.moataz.bosta_task.features.photos.domain.entities.Photo

interface PhotosRepository {
    suspend fun getAlbumPhotos(albumId: Long): List<Photo>
}