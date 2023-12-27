package com.moataz.bosta_task.features.profile.data.repositories.mapper

import com.moataz.bosta_task.features.profile.data.remote.dto.album.AlbumDTO
import com.moataz.bosta_task.features.profile.data.remote.dto.user.AddressDTO
import com.moataz.bosta_task.features.profile.data.remote.dto.user.UserDTO
import com.moataz.bosta_task.features.profile.domain.entities.album.Album
import com.moataz.bosta_task.features.profile.domain.entities.user.Address
import com.moataz.bosta_task.features.profile.domain.entities.user.User

/**
 * User's
 */
internal fun List<UserDTO>.toUsers() = map { it.toUser() }

internal fun UserDTO.toUser() = User(
    id = id ?: 0,
    name = name ?: "",
    username = username ?: "",
    email = email ?: "",
    address = address.toAddress(),
)

internal fun AddressDTO.toAddress() = Address(
    street = street ?: "",
    suite = suite ?: "",
    city = city ?: "",
    zipcode = zipcode ?: "",
)

/**
 * Album's
 */
internal fun List<AlbumDTO>.toAlbums() = map { it.toAlbum() }

internal fun AlbumDTO.toAlbum() = Album(
    id = id ?: 0,
    title = title ?: "",
)