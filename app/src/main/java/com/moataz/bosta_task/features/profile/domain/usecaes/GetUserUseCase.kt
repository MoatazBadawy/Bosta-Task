package com.moataz.bosta_task.features.profile.domain.usecaes

import com.moataz.bosta_task.features.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke() =
        profileRepository.getAllUsers().random()
}