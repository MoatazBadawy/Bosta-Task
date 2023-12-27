package com.moataz.bosta_task.features.profile.data.remote.dto.user

import com.google.gson.annotations.SerializedName

data class AddressDTO(
    @SerializedName("street")
    val street: String?,
    @SerializedName("suite")
    val suite: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("zipcode")
    val zipcode: String?,
)