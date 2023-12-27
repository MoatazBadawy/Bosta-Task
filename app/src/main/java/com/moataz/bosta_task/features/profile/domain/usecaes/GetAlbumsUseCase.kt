package com.moataz.bosta_task.features.profile.domain.usecaes

import com.moataz.bosta_task.features.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val user: GetUserUseCase
) {
    suspend operator fun invoke() =
        profileRepository.getAlbumsByUserId(user().id)
}