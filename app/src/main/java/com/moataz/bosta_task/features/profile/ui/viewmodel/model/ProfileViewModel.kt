package com.moataz.bosta_task.features.profile.ui.viewmodel.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moataz.bosta_task.app.di.utils.IoDispatcher
import com.moataz.bosta_task.features.profile.domain.usecaes.GetAlbumsUseCase
import com.moataz.bosta_task.features.profile.domain.usecaes.GetUserUseCase
import com.moataz.bosta_task.features.profile.ui.viewmodel.ProfileUIState
import com.moataz.bosta_task.features.profile.ui.viewmodel.mapper.toAlbumsUI
import com.moataz.bosta_task.features.profile.ui.viewmodel.mapper.toUserUI
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.user.UserUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getAlbumsForUserUseCase: GetAlbumsUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _profileState = MutableStateFlow(ProfileUIState())
    val profileState get() = _profileState.asStateFlow()

    init {
        getUserProfileInformation()
    }

    private fun getUserProfileInformation() {
        viewModelScope.launch(ioDispatcher) {
            try {
                _profileState.update { userProfileInfoUIState ->
                    userProfileInfoUIState.copy(
                        user = getUserUseCase().toUserUI(),
                        albums = getAlbumsForUserUseCase().toAlbumsUI(),
                        isSuccessful = true,
                        isLoading = false,
                        isError = false,
                    )

                }
            } catch (e: Exception) {
                _profileState.value = ProfileUIState(
                    user = UserUI(),
                    albums = emptyList(),
                    isLoading = false,
                    isSuccessful = false,
                    isError = true,
                )
            }
        }
    }
}