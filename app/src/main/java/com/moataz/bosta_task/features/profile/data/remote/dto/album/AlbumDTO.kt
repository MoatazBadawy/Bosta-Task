package com.moataz.bosta_task.features.profile.data.remote.dto.album

import com.google.gson.annotations.SerializedName

data class AlbumDTO(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("title")
    val title: String?,
)