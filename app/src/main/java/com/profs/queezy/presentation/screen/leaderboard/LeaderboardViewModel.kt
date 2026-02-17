package com.profs.queezy.presentation.screen.leaderboard

import androidx.lifecycle.ViewModel
import com.profs.queezy.domain.service.DomainService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LeaderboardViewModel @Inject constructor(private val service: DomainService): ViewModel() {

}