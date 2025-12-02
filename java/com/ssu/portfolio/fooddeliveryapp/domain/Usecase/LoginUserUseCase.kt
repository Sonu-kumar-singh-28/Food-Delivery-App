package com.ssu.portfolio.fooddeliveryapp.domain.Usecase

import com.google.android.play.core.integrity.t
import com.ssu.portfolio.fooddeliveryapp.common.ResultState
import com.ssu.portfolio.fooddeliveryapp.data.models.userData
import com.ssu.portfolio.fooddeliveryapp.domain.repo.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(val  repo: Repo){

    fun loginUser(userData: userData): Flow<ResultState<String>>{
        return repo.loginWithEmailAndPassword(userData)
    }

}