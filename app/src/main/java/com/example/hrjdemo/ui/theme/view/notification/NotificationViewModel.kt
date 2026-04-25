package com.example.hrjdemo.ui.theme.view.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import com.loyaltyworks.hrjohnson.model.HistoryNotificationRequest
import com.loyaltyworks.hrjohnson.model.HistoryNotificationResponse
import com.loyaltyworks.hrjohnson.model.LstPushHistoryJson
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class NotificationViewModel @Inject constructor(
    val preferenceHelper: PreferenceHelper,
    private val apiRepository: ApiRepository,
) : ViewModel() {

    private val _notificationList = MutableStateFlow<UiState<HistoryNotificationResponse>>(UiState.Idle)
    val notification: StateFlow<UiState<HistoryNotificationResponse>> = _notificationList.asStateFlow()

    var notificationListing = mutableListOf<LstPushHistoryJson>()
    val pageSize = 6
    var startIndex = 1
    var isLastdata = false
    var isLoading = MutableStateFlow(false)

    fun notificationList(
        historyNotificationRequest: HistoryNotificationRequest,
        isRefresh: Boolean = false,
    ) {

        if (isRefresh) {
            startIndex = 1
            isLastdata = false
            notificationListing.clear()
        }

        if (isLastdata) return

        viewModelScope.launch {
            if (isRefresh) {
                _notificationList.value = UiState.Loading
            } else {
                isLoading.value = true
            }

            val request = historyNotificationRequest.copy(startIndex = startIndex, pageSize = pageSize)

            when (val response = apiRepository.notificationList(request)) {
                is NetworkResult.Success -> {
                    val newItems = response.data.lstPushHistoryJson ?: emptyList()
                    notificationListing.addAll(newItems)

                    if (newItems.size < pageSize) {
                        isLastdata = true
                    } else {
                        startIndex++
                    }

                    _notificationList.value = (UiState.Success(response.data.copy(lstPushHistoryJson = notificationListing)))
                }

                is NetworkResult.Error -> {
                    _notificationList.value = UiState.Error(response.message, response.code)
                }
            }

            isLoading.value = false
        }
    }
}