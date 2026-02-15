package com.profs.queezy.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.profs.queezy.data.model.User
import com.profs.queezy.data.model.response.UserResponse
import com.profs.queezy.data.utils.Storage
import com.profs.queezy.domain.service.DomainService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val service: DomainService) : ViewModel() {

    val quizzes = service.getQuizzes()

    private val _userData = MutableStateFlow<UserResponse?>(null)
    val userData: StateFlow<UserResponse?> = _userData

    fun getProfile() {
        viewModelScope.launch {
            _userData.value = service.getProfile()
        }
    }

    init {
        getProfile()
    }

}