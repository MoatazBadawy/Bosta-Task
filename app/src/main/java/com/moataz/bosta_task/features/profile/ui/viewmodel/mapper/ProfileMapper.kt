package com.moataz.bosta_task.features.profile.ui.viewmodel.mapper

import com.moataz.bosta_task.features.profile.domain.entities.album.Album
import com.moataz.bosta_task.features.profile.domain.entities.user.Address
import com.moataz.bosta_task.features.profile.domain.entities.user.User
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.album.AlbumUI
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.user.AddressUI
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.user.UserUI

/**
 * User's
 */
internal fun User.toUserUI() = UserUI(
    id = id,
    name = name,
    username = username,
    email = email,
    address = address.toAddressUI(),
)

internal fun Address.toAddressUI() = AddressUI(
    street = street,
    suite = suite,
    city = city,
    zipcode = zipcode,
)

/**
 * Album's
 */
internal fun List<Album>.toAlbumsUI() = map { it.toAlbumUI() }

internal fun Album.toAlbumUI() = AlbumUI(
    id = id,
    title = title,
)