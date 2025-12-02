package com.ssu.portfolio.fooddeliveryapp.domain.Usecase

import com.google.android.play.core.integrity.t
import com.ssu.portfolio.fooddeliveryapp.common.ResultState
import com.ssu.portfolio.fooddeliveryapp.data.models.userData
import com.ssu.portfolio.fooddeliveryapp.domain.repo.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(val  repo: Repo){

    fun createUser(userData: userData): Flow<ResultState<String>>{
        return repo.registerWithEmailAndPassword(userData)
    }
}