package com.moataz.bosta_task.features.profile.data.remote.dto.user

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("address")
    val address: AddressDTO,
)