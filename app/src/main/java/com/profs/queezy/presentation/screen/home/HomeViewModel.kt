package com.profs.queezy.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.profs.queezy.data.utils.Storage
import com.profs.queezy.domain.service.DomainService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val service: DomainService) : ViewModel() {

    val quizzes = service.getQuizzes()

}