package com.example.hrjdemo.ui.theme.view.accountSelection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrjdemo.ui.theme.utils.apicall.ApiRepository
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.loyaltyworks.hrjohnson.model.AccountTypeRequest
import com.loyaltyworks.hrjohnson.model.AccountTypeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountSelectionViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    ViewModel() {

    private val _accountTypeData = MutableLiveData<NetworkResult<AccountTypeResponse>>()
    val accountTypeData: LiveData<NetworkResult<AccountTypeResponse>> = _accountTypeData

    fun getAccountType(accountTypeRequest: AccountTypeRequest) {
        viewModelScope.launch {
            _accountTypeData.value = apiRepository.getAccountType(accountTypeRequest)
        }
    }
}