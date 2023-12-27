package com.moataz.bosta_task.features.photos.ui.viewmodel.mapper

import com.moataz.bosta_task.features.photos.domain.entities.Photo
import com.moataz.bosta_task.features.photos.ui.viewmodel.model.PhotoUI

internal fun List<Photo>.toPhotosUI() = map { it.toPhotoUI() }

internal fun Photo.toPhotoUI() = PhotoUI(
    albumId = albumId,
    id = id,
    title = title,
    url = url,
    thumbnailUrl = thumbnailUrl
)