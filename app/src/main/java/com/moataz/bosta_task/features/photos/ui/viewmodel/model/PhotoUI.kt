package com.moataz.bosta_task.features.photos.ui.viewmodel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoUI(
    val albumId: Long = 0,
    val id: Long = 0,
    val title: String = "",
    val url: String = "",
    val thumbnailUrl: String = ""
) : Parcelable