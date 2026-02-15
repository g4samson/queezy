package com.profs.queezy.domain.usecase

import com.profs.queezy.domain.repository.UserRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke() = repository.currentUser
}