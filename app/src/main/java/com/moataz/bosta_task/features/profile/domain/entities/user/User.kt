package com.moataz.bosta_task.features.profile.domain.entities.user

data class User(
    val id: Long = 0,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val address: Address = Address(),
)