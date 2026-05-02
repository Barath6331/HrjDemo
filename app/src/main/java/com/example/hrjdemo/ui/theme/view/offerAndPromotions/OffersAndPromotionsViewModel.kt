package com.example.hrjdemo.ui.theme.view.offerAndPromotions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import com.loyaltyworks.hrjohnson.model.PromotionListRequest
import com.loyaltyworks.hrjohnson.model.PromotionListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class OffersAndPromotionsViewModel @Inject constructor(private val apiRepository: ApiRepository,val preferenceHelper: PreferenceHelper) :
    ViewModel() {

    private val _offersAndPromotionList = MutableStateFlow<UiState<PromotionListResponse>>(UiState.Idle)
    val offersAndPromotionList: StateFlow<UiState<PromotionListResponse>> = _offersAndPromotionList.asStateFlow()

    fun getOffersAndPromotion(promotionListRequest: PromotionListRequest) {
        viewModelScope.launch {
            _offersAndPromotionList.value = UiState.Loading

            when (val response = apiRepository.getOffersAndPromotion(promotionListRequest)) {
                is NetworkResult.Success -> {
                    _offersAndPromotionList.value = UiState.Success(response.data)
                }

                is NetworkResult.Error -> {
                    _offersAndPromotionList.value = UiState.Error(response.message, response.code)
                }
            }
        }
    }
}