package com.profs.queezy.domain.service

import com.profs.queezy.data.model.Quiz
import com.profs.queezy.data.model.User
import com.profs.queezy.data.model.response.UserResponse

interface DomainService {

    fun getQuizzes() : List<Quiz>

    fun getFriends() : List<User>

    suspend fun getProfile() : UserResponse?

}