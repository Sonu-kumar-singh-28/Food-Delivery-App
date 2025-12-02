package com.ssu.portfolio.fooddeliveryapp.domain.repo

import android.R
import com.ssu.portfolio.fooddeliveryapp.common.ResultState
import com.ssu.portfolio.fooddeliveryapp.data.models.userData
import kotlinx.coroutines.flow.Flow

interface Repo {

    fun loginWithEmailAndPassword(userData: userData): Flow<ResultState<String>>

    fun registerWithEmailAndPassword(userData: userData): Flow<ResultState<String>>


}