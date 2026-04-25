package com.example.hrjdemo.ui.theme.view.dealerLocator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import com.loyaltyworks.hrjohnson.model.DealerDetail
import com.loyaltyworks.hrjohnson.model.DealerLisingRequest
import com.loyaltyworks.hrjohnson.model.DealerListingResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealerLocatorViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    val preferenceHelper: PreferenceHelper,
) :
    ViewModel() {

    private val _dealerListing = MutableStateFlow<UiState<DealerListingResponse>>(UiState.Idle)
    val dealerLocatorList: StateFlow<UiState<DealerListingResponse>> = _dealerListing.asStateFlow()

    val dealerListingPagination = mutableListOf<DealerDetail>()
    var startIndex = 1
    var pageSize = 10
    var isLastPage = false
    var isLoading = MutableStateFlow(false)

    fun dealerList(dealerLisingRequest: DealerLisingRequest, isRefresh: Boolean = false) {

        if (isRefresh) {
            startIndex = 1
            isLastPage = false
            dealerListingPagination.clear()
        }

        if (isLastPage) return

        viewModelScope.launch {
            if (isRefresh) {
                _dealerListing.value = UiState.Loading
            } else {
                isLoading.value = true
            }
            val request = dealerLisingRequest.copy(pageNo = pageSize, starIndex = startIndex)

            when (val response = apiRepository.dealerLocatorList(request)) {
                is NetworkResult.Success -> {
                    val newList = response.data.dealerDetails ?: emptyList()
                    dealerListingPagination.addAll(newList)

                    if (newList.size < pageSize) {
                        isLastPage = true
                    } else {
                        startIndex += 1
                    }

                    _dealerListing.value = UiState.Success(response.data.copy(dealerDetails = dealerListingPagination.toList()))
                }

                is NetworkResult.Error -> {
                    _dealerListing.value = UiState.Error(response.message, response.code)
                }
            }

            isLoading.value = false
        }
    }
}