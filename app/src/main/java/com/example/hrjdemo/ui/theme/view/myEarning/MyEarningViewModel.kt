package com.example.hrjdemo.ui.theme.view.myEarning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import com.loyaltyworks.hrjohnson.model.MyEarningRequest
import com.loyaltyworks.hrjohnson.model.MyEarningResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MyEarningViewModel @Inject constructor(private val apiRepository: ApiRepository,val preferenceHelper: PreferenceHelper) :
    ViewModel() {

    private val _myEarningList = MutableStateFlow<UiState<MyEarningResponse>>(UiState.Idle)
    val myEarningList: StateFlow<UiState<MyEarningResponse>> = _myEarningList.asStateFlow()

    fun getEarningList(myEarningRequest: MyEarningRequest) {
        viewModelScope.launch {
            _myEarningList.value = UiState.Loading

            when (val response = apiRepository.getMyEarningList(myEarningRequest)) {
                is NetworkResult.Success -> {
                    _myEarningList.value = UiState.Success(response.data)
                }

                is NetworkResult.Error -> {
                    _myEarningList.value = UiState.Error(response.message, response.code)
                }
            }
        }
    }
}