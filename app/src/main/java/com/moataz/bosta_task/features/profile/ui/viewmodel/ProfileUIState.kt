package com.moataz.bosta_task.features.profile.ui.viewmodel

import com.moataz.bosta_task.features.profile.ui.viewmodel.model.album.AlbumUI
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.user.UserUI

data class ProfileUIState(
    val user: UserUI = UserUI(),
    val albums: List<AlbumUI> = emptyList(),
    val isLoading: Boolean = true,
    val isSuccessful: Boolean = false,
    val isError: Boolean = false,
)