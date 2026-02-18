package com.profs.queezy.presentation.screen.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.profs.queezy.R
import com.profs.queezy.data.model.User
import com.profs.queezy.data.model.response.LeaderboardResponseItem
import com.profs.queezy.data.model.response.UserResponse
import com.profs.queezy.domain.service.DomainService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val service: DomainService) : ViewModel() {

    val badges = service.getBadges()

    private val _userData = MutableStateFlow<User?>(null)
    val userData: StateFlow<User?> = _userData

    private val _leaderboard = MutableStateFlow<List<LeaderboardResponseItem>?>(null)
    //val leaderboard : StateFlow<List<LeaderboardResponseItem>?> = _leaderboard

    private val _rank = MutableStateFlow<Int?>(0)
    val rank: StateFlow<Int?> = _rank

    private val _page = MutableStateFlow(0)
    val page: StateFlow<Int> = _page

    fun getProfile() {
        viewModelScope.launch {
            _userData.value = service.getProfile()?.asDomainModel()
        }
    }

    fun getLeaderboard() {
        viewModelScope.launch {
            val lb = service.getLeaderboard()
            _leaderboard.value = lb

            val myId = "224b9ef7-23bd-4b4a-81a4-2405bba67624"
            _rank.value = lb?.sortedByDescending { it.points }
                ?.indexOfFirst { it.id == myId }?.plus(1)

            Log.e("DD", "RANK - ${_rank.value}")
        }
    }

    fun savePage(page: Int) {
        _page.value = page
    }

    private fun UserResponse.asDomainModel(): User {
        return User(
            this.id,
            this.first_name,
            this.last_name,
            590,
            R.drawable.flag_ireland,
            this.image,
        )
    }

    init {
        getProfile()
        getLeaderboard()
    }
}