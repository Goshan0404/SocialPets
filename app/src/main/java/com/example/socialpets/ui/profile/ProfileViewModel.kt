package com.example.socialpets.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialpets.data.model.Profile
import com.example.socialpets.data.repository.ProfileRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async

class ProfileViewModel: ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getProfileData(): Profile {
        return viewModelScope.async {
            ProfileRepository.getProfile()
        }.getCompleted()
    }
}