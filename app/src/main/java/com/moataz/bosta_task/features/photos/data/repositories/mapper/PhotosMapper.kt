package com.moataz.bosta_task.features.photos.data.repositories.mapper

import com.moataz.bosta_task.features.photos.data.remote.dto.PhotoDTO
import com.moataz.bosta_task.features.photos.domain.entities.Photo

internal fun List<PhotoDTO>.toPhotos() = map { it.toPhoto() }

internal fun PhotoDTO.toPhoto() = Photo(
    albumId = albumId ?: 0,
    id = id ?: 0,
    title = title ?: "",
    url = url ?: "",
    thumbnailUrl = thumbnailUrl ?: ""
)