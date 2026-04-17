package com.example.hrjdemo.ui.theme.view.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PrefKey
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PreferenceHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(val preferenceHelper: PreferenceHelper) : ViewModel() {


}