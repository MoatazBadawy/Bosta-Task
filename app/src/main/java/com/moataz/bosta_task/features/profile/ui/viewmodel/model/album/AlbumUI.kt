package com.moataz.bosta_task.features.profile.ui.viewmodel.model.album

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumUI(
    val id: Long = 0,
    val title: String = "",
) : Parcelable