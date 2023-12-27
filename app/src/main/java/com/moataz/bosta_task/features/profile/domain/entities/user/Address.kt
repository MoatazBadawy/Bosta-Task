package com.moataz.bosta_task.features.profile.domain.entities.user

data class Address(
    val street: String = "",
    val suite: String = "",
    val city: String = "",
    val zipcode: String = "",
)