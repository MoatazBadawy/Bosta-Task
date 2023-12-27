package com.moataz.bosta_task.features.photos.data.remote

import com.moataz.bosta_task.features.photos.data.remote.dto.PhotoDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosService {
    @GET("photos")
    suspend fun getAlbumPhotos(
        @Query("albumId") albumId: Long
    ): List<PhotoDTO>
}