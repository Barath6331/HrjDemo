package com.example.hrjdemo.ui.theme.view.loginRegister.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginResponse
import com.example.hrjdemo.ui.theme.utils.model.RegistrationRequest
import com.example.hrjdemo.ui.theme.utils.model.RegistrationResponse
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.loyaltyworks.hrjohnson.model.CityListRequest
import com.loyaltyworks.hrjohnson.model.CityListResponse
import com.loyaltyworks.hrjohnson.model.StateListRequest
import com.loyaltyworks.hrjohnson.model.StateListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(val preferenceHelper: PreferenceHelper,private val apiRepository: ApiRepository) :
    ViewModel() {

    private val _stateList = MutableStateFlow<UiState<StateListResponse>>(UiState.Idle)
    val stateList: StateFlow<UiState<StateListResponse>> = _stateList.asStateFlow()

    fun getStateList(stateListRequest: StateListRequest) {
        viewModelScope.launch {
            _stateList.value = UiState.Loading

            when (val respones = apiRepository.getState(stateListRequest)) {
                is NetworkResult.Success -> {
                    _stateList.value = UiState.Success(respones.data)
                }

                is NetworkResult.Error -> {
                    _stateList.value = UiState.Error(respones.message, respones.code)
                }
            }
        }
    }

    private val _cityList = MutableStateFlow<UiState<CityListResponse>>(UiState.Idle)
    val cityList: StateFlow<UiState<CityListResponse>> = _cityList.asStateFlow()

    fun getCityList(cityListRequest: CityListRequest) {
        viewModelScope.launch {
            _cityList.value = UiState.Loading

            when (val respones = apiRepository.getCity(cityListRequest)) {
                is NetworkResult.Success -> {
                    _cityList.value = UiState.Success(respones.data)
                }

                is NetworkResult.Error -> {
                    _cityList.value = UiState.Error(respones.message, respones.code)
                }
            }
        }
    }


    private val _registrationValue = MutableStateFlow<UiState<RegistrationResponse>>(UiState.Idle)
    val registrationValue: StateFlow<UiState<RegistrationResponse>> =
        _registrationValue.asStateFlow()

    fun registrationApi(registrationRequest: RegistrationRequest) {
        viewModelScope.launch {
            _registrationValue.value = UiState.Loading

            when (val response = apiRepository.regisrationApi(registrationRequest)) {
                is NetworkResult.Success -> {
                    _registrationValue.value = UiState.Success(response.data)
                }

                is NetworkResult.Error -> {
                    _registrationValue.value = UiState.Error(response.message, response.code)
                }
            }
        }
    }

    private val _loginData = MutableStateFlow<UiState<LoginResponse>>(UiState.Idle)
    val loginData: StateFlow<UiState<LoginResponse>> = _loginData.asStateFlow()

    fun loginRequest(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _loginData.value = UiState.Loading

            when (val response = apiRepository.getLoginDetails(loginRequest)) {
                is NetworkResult.Success -> {
                    _loginData.value = UiState.Success(response.data)
                }

                is NetworkResult.Error -> {
                    _loginData.value = UiState.Error(response.message, response.code)
                }
            }
        }
    }
}