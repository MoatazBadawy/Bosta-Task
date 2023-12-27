package com.moataz.bosta_task.features.photos.domain.entities

data class Photo(
    val albumId: Long = 0,
    val id: Long = 0,
    val title: String = "",
    val url: String = "",
    val thumbnailUrl: String = ""
)
