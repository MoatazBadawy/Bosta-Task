package com.moataz.bosta_task.features.profile.data.repositories

import com.moataz.bosta_task.features.profile.data.remote.ProfileService
import com.moataz.bosta_task.features.profile.data.repositories.mapper.toAlbums
import com.moataz.bosta_task.features.profile.data.repositories.mapper.toUsers
import com.moataz.bosta_task.features.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileRemoteService: ProfileService
) : ProfileRepository {
    override suspend fun getAllUsers() =
        profileRemoteService.getAllUsers().toUsers()

    override suspend fun getAlbumsByUserId(userId: Long) =
        profileRemoteService.getAlbumsByUserId(userId).toAlbums()
}