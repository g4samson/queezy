package com.profs.queezy.presentation.screen.leaderboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.profs.queezy.data.model.response.LeaderboardResponseItem
import com.profs.queezy.domain.service.DomainService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaderboardViewModel @Inject constructor(private val service: DomainService): ViewModel() {

    private val _leaderboard = MutableStateFlow<List<LeaderboardResponseItem>?>(null)
    val leaderboard : StateFlow<List<LeaderboardResponseItem>?> = _leaderboard

    fun getLeaderboard() {
        viewModelScope.launch {
            val lb = service.getLeaderboard()
            _leaderboard.value = lb
        }
    }

    private val _opened = MutableStateFlow<Boolean>(false)
    val opened: StateFlow<Boolean> = _opened

    fun saveState(i: Boolean) {
        _opened.value = i
    }

    init {
        getLeaderboard()
    }

}