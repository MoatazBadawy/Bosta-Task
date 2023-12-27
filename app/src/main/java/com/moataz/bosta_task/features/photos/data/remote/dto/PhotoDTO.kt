package com.moataz.bosta_task.features.photos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PhotoDTO(
    @SerializedName("albumId")
    val albumId: Long?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?
)
