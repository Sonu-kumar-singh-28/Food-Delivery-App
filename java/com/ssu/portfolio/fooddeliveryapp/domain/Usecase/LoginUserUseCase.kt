package com.ssu.portfolio.fooddeliveryapp.domain.Usecase

import com.ssu.portfolio.fooddeliveryapp.common.ResultState
import com.ssu.portfolio.fooddeliveryapp.data.models.userData
import com.ssu.portfolio.fooddeliveryapp.domain.repo.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val repo: Repo
) {
    fun loginUser(email: String, password: String): Flow<ResultState<String>> {

        // Create userData object for login
        val user = userData(
            email = email,
            password = password
        )

        return repo.loginWithEmailAndPassword(user)
    }
}
