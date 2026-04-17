package com.example.hrjdemo.ui.theme.view.accountSelection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PrefKey
import com.loyaltyworks.hrjohnson.model.AccountTypeRequest
import com.loyaltyworks.hrjohnson.model.AccountTypeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountSelectionViewModel @Inject constructor(private val apiRepository: ApiRepository,private val preferenceHelper: PreferenceHelper) : ViewModel() {

    fun saveCustomerID(customerId:String){
        preferenceHelper.setStringValue(PrefKey.CustomerType,customerId)
    }
    // Using the common generic UiState!
    private val _accountTypeData = MutableStateFlow<UiState<AccountTypeResponse>>(UiState.Idle)
    val accountTypeData: StateFlow<UiState<AccountTypeResponse>> = _accountTypeData.asStateFlow()

    fun getAccountType(accountTypeRequest: AccountTypeRequest) {
        viewModelScope.launch {
            // Emitting Loading state before network call
            _accountTypeData.value = UiState.Loading

            // Assuming your repository returns a NetworkResult
            when (val result = apiRepository.getAccountType(accountTypeRequest)) {
                is NetworkResult.Success -> {
                    _accountTypeData.value = UiState.Success(result.data)
                }
                is NetworkResult.Error -> {
                    _accountTypeData.value = UiState.Error(result.message, result.code)
                }
            }
        }
    }
}