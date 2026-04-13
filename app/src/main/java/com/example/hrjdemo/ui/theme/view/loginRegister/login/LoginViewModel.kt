package com.example.hrjdemo.ui.theme.view.loginRegister.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginResponse
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    private val _loginData = MutableLiveData<NetworkResult<LoginResponse>>()
    val loginData: LiveData<NetworkResult<LoginResponse>> = _loginData

    fun loginRequest(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _loginData.value = apiRepository.getLoginDetails(loginRequest)
        }
    }
}