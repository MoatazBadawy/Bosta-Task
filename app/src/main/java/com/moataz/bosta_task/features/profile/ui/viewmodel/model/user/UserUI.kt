package com.moataz.bosta_task.features.profile.ui.viewmodel.model.user

data class UserUI(
    val id: Long = 0,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val address: AddressUI = AddressUI(),
)