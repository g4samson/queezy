package com.profs.queezy.domain.service

import com.profs.queezy.data.model.Badge
import com.profs.queezy.data.model.Quiz
import com.profs.queezy.data.model.User
import com.profs.queezy.data.model.response.LeaderboardResponse
import com.profs.queezy.data.model.response.LeaderboardResponseItem
import com.profs.queezy.data.model.response.UserResponse

interface DomainService {

    fun getQuizzes() : List<Quiz>

    fun getFriends() : List<User>

    fun getBadges() : List<Badge>

    suspend fun getProfile() : UserResponse?

    suspend fun getLeaderboard() : List<LeaderboardResponseItem>?


}