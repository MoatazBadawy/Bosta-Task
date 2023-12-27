package com.moataz.bosta_task.features.profile.data.remote

import com.moataz.bosta_task.features.profile.data.remote.dto.album.AlbumDTO
import com.moataz.bosta_task.features.profile.data.remote.dto.user.UserDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileService {
    @GET("users")
    suspend fun getAllUsers(): List<UserDTO>

    @GET("albums")
    suspend fun getAlbumsByUserId(
        @Query("userId") userId: Long
    ): List<AlbumDTO>
}