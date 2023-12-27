package com.moataz.bosta_task.features.profile.domain.repository

import com.moataz.bosta_task.features.profile.domain.entities.album.Album
import com.moataz.bosta_task.features.profile.domain.entities.user.User

interface ProfileRepository {
    suspend fun getAllUsers(): List<User>
    suspend fun getAlbumsByUserId(userId: Long): List<Album>
}