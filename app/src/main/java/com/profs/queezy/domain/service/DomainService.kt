package com.profs.queezy.domain.service

import com.profs.queezy.data.model.Quiz
import com.profs.queezy.data.model.response.UserResponse

interface DomainService {

    fun getQuizzes() : List<Quiz>

    suspend fun getProfile() : UserResponse?

}