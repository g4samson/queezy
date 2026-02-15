package com.profs.queezy.presentation.screen.discover

import androidx.lifecycle.ViewModel
import com.profs.queezy.domain.service.DomainService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(private val service: DomainService) : ViewModel() {

    val quizzes = service.getQuizzes().take(2)

    val friends = service.getFriends().take(3)

}