package com.ssu.portfolio.fooddeliveryapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssu.portfolio.fooddeliveryapp.common.ResultState
import com.ssu.portfolio.fooddeliveryapp.data.models.userData
import com.ssu.portfolio.fooddeliveryapp.domain.Usecase.CreateUserUseCase
import com.ssu.portfolio.fooddeliveryapp.domain.Usecase.LoginUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ZomViewModel @Inject constructor(
    private val createUserUseCase: CreateUserUseCase,
    private val loginUserUseCase: LoginUserUseCase
) : ViewModel() {

    private val _signUpScreenState = MutableStateFlow(SignUpScreenState())
    val signUpScreenState = _signUpScreenState.asStateFlow()

    private val _loginScreenState = MutableStateFlow(LoginScreenState())
    val loginScreenState = _loginScreenState.asStateFlow()

    fun createUser(userData: userData) {
        viewModelScope.launch {
            createUserUseCase.createUser(userData).collect { result ->
                when (result) {
                    is ResultState.Loading -> {
                        _signUpScreenState.value = _signUpScreenState.value.copy(isLoading = true)
                    }
                    is ResultState.Success -> {
                        _signUpScreenState.value = _signUpScreenState.value.copy(
                            isLoading = false,
                            isSuccess = true,
                            errorMessage = ""
                        )
                    }
                    is ResultState.Error -> {
                        _signUpScreenState.value = _signUpScreenState.value.copy(
                            isLoading = false,
                            errorMessage = result.message
                        )
                    }
                }
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            loginUserUseCase.loginUser(email, password).collect { result ->
                when (result) {
                    is ResultState.Loading -> {
                        _loginScreenState.value = _loginScreenState.value.copy(isLoading = true)
                    }
                    is ResultState.Success -> {
                        _loginScreenState.value = _loginScreenState.value.copy(
                            isLoading = false,
                            isSuccess = true,
                            errorMessage = ""
                        )
                    }
                    is ResultState.Error -> {
                        _loginScreenState.value = _loginScreenState.value.copy(
                            isLoading = false,
                            errorMessage = result.message
                        )
                    }
                }
            }
        }
    }
}

data class SignUpScreenState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)

data class LoginScreenState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)