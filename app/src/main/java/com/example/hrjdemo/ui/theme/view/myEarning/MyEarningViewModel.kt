package com.example.hrjdemo.ui.theme.view.myEarning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import com.loyaltyworks.hrjohnson.model.LstRewardTransJsonDetail
import com.loyaltyworks.hrjohnson.model.MyEarningRequest
import com.loyaltyworks.hrjohnson.model.MyEarningResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MyEarningViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    val preferenceHelper: PreferenceHelper
) :
    ViewModel() {

    private val _myEarningList = MutableStateFlow<UiState<MyEarningResponse>>(UiState.Idle)
    val myEarningList: StateFlow<UiState<MyEarningResponse>> = _myEarningList.asStateFlow()

    private val _earningsList = mutableListOf<LstRewardTransJsonDetail>()
    var startIndex = 1
    private val pageSize = 20
    var isEndReached = false
    var isNextPageLoading = MutableStateFlow(false)

    fun getEarningList(myEarningRequest: MyEarningRequest, isInitialLoad: Boolean = false) {
        if (isInitialLoad) {
            startIndex = 1
            isEndReached = false
            _earningsList.clear()
        }

        if (isEndReached) return

        viewModelScope.launch {
            if (isInitialLoad) {
                _myEarningList.value = UiState.Loading
            } else {
                isNextPageLoading.value = true
            }

            // Ensure request uses the current startIndex and pageSize
            val request = myEarningRequest.copy(startIndex = startIndex, pageSize = pageSize)

            when (val response = apiRepository.getMyEarningList(request)) {
                is NetworkResult.Success -> {
                    val newItems = response.data.lstRewardTransJsonDetails ?: emptyList()
                    _earningsList.addAll(newItems)

                    if (_earningsList.size < pageSize) {
                        isEndReached = true
                    } else {
                        startIndex += 1
                    }

                    // Create a new response object with the accumulated list to trigger UI update
                    _myEarningList.value = UiState.Success(
                        response.data.copy(lstRewardTransJsonDetails = _earningsList.toList())
                    )
                }

                is NetworkResult.Error -> {
                    _myEarningList.value = UiState.Error(response.message, response.code)
                }
            }
            isNextPageLoading.value = false
        }
    }
}