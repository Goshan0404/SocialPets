package com.example.socialpets.ui.profile

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialpets.Resource
import com.example.socialpets.data.model.Profile
import com.example.socialpets.data.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _uiState: MutableState<UiState> = mutableStateOf(UiState())
    val uiState: State<UiState> = _uiState

    init {
        requestProfileData()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    fun requestProfileData() {
        val resource = viewModelScope.launch {
            when (val data = ProfileRepository.getProfile()) {
                is Resource.Success -> {
                    _uiState.value = UiState(data = data.data)
                }

                is Resource.Error -> {
                    _uiState.value = UiState(error = UiState.Error.NetworkError)
                }
            }
        }
    }


    data class UiState(
        val isLoading: Boolean = false,
        val data: Profile? = null,
        val error: Error? = null
    ) {
        enum class Error {
            NetworkError
        }
    }
}