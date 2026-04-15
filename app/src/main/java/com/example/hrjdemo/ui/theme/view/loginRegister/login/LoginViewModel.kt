package com.example.hrjdemo.ui.theme.view.loginRegister.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.PreferenceHelper
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.model.EmailExistencyChekRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginResponse
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationRequest
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationResponse
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsRequest
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsResponse
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.loyaltyworks.hrjohnson.model.AccountTypeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    private val preferenceHelper: PreferenceHelper,
) : ViewModel() {

    fun getCustomerID(): String {
        return preferenceHelper.getStringValue("CustomerType")
    }

    private val _loginData = MutableLiveData<NetworkResult<LoginResponse>>()
    val loginData: LiveData<NetworkResult<LoginResponse>> = _loginData

    fun loginRequest(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _loginData.value = apiRepository.getLoginDetails(loginRequest)
        }
    }

    private val _existency = MutableStateFlow<UiState<Int>>(UiState.Idle)
    val existency: StateFlow<UiState<Int>> = _existency.asStateFlow()

    fun existencyCheck(emailExistencyChekRequest: EmailExistencyChekRequest) {
        viewModelScope.launch {
            _existency.value = UiState.Loading

            when (val resposne = apiRepository.checkExistency(emailExistencyChekRequest)) {
                is NetworkResult.Success -> {
                    _existency.value = UiState.Success(resposne.data)
                }

                is NetworkResult.Error -> {
                    _existency.value = UiState.Error(resposne.message, resposne.code)
                }
            }
        }
    }


    private val _getOtp = MutableStateFlow<UiState<SaveAndGetOTPDetailsResponse>>(UiState.Idle)
    val getOtp: StateFlow<UiState<SaveAndGetOTPDetailsResponse>> = _getOtp.asStateFlow()

    fun getOtp(saveAndGetOTPDetailsRequest: SaveAndGetOTPDetailsRequest) {
        viewModelScope.launch {
            _getOtp.value = UiState.Loading

            when (val response = apiRepository.sentOtp(saveAndGetOTPDetailsRequest)) {
                is NetworkResult.Success -> {
                    _getOtp.value = UiState.Success(response.data)
                }

                is NetworkResult.Error -> {
                    _getOtp.value = UiState.Error(response.message, response.code)
                }
            }
        }
    }


    private val _validateOtp = MutableStateFlow<UiState<OTPValidationResponse>>(UiState.Idle)
    val validateOtp: StateFlow<UiState<OTPValidationResponse>> = _validateOtp.asStateFlow()

    fun validateOtpApi(otpValidationRequest: OTPValidationRequest) {
        viewModelScope.launch {
            _validateOtp.value = UiState.Loading

            when (val response = apiRepository.validateOtp(otpValidationRequest)) {
                is NetworkResult.Success -> {
                    _validateOtp.value = UiState.Success(response.data)
                }

                is NetworkResult.Error -> {
                    _validateOtp.value = UiState.Error(response.message, response.code)
                }
            }
        }
    }
}