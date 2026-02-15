package com.profs.queezy.domain.service

import com.profs.queezy.data.model.Quiz
import com.profs.queezy.data.model.User
import com.profs.queezy.data.model.response.UserResponse
import com.profs.queezy.data.utils.Provider
import com.profs.queezy.data.utils.Storage
import javax.inject.Inject

class DomainServiceImpl @Inject constructor(private val storage: Storage) : DomainService {

    private val retrofit get() = Provider.provideRetrofit()

    override fun getQuizzes() = storage.getQuizzes()

    override fun getFriends() = storage.getFriends()

    override suspend fun getProfile(): UserResponse? {
        return try {
            return retrofit.getProfile()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}