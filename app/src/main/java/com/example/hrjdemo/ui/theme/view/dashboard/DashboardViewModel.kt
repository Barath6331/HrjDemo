package com.example.hrjdemo.ui.theme.view.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import com.loyaltyworks.hrjohnson.model.UpdatedDashboardSingleApiRequest
import com.loyaltyworks.hrjohnson.model.UpdatedDashboardSingleApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    val preferenceHelper: PreferenceHelper,
) : ViewModel() {

    private val _dashboardDetils =
        MutableStateFlow<UiState<UpdatedDashboardSingleApiResponse>>(UiState.Idle)
    val dashbaordDetails: StateFlow<UiState<UpdatedDashboardSingleApiResponse>> =
        _dashboardDetils.asStateFlow()

    fun getDashboardDetails(updatedDashboardSingleApiRequest: UpdatedDashboardSingleApiRequest) {
        viewModelScope.launch {
            _dashboardDetils.value = UiState.Loading

            when (val response =
                apiRepository.getDashboardDetails(updatedDashboardSingleApiRequest)) {
                is NetworkResult.Success -> {
                    _dashboardDetils.value = UiState.Success(response.data)
                }

                is NetworkResult.Error -> {
                    _dashboardDetils.value = UiState.Error(response.message, response.code)
                }
            }
        }
    }
}