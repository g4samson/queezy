package com.profs.queezy.domain.repository

import com.profs.queezy.data.model.User
import kotlinx.coroutines.flow.StateFlow

interface UserRepository {

    val currentUser: StateFlow<User?>

    suspend fun setUser(user: User)

    suspend fun clearUser()

}