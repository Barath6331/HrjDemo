package com.example.hrjdemo.ui.theme.utils.model

data class DashboardItem(
    val image: Int,
    val title: String,
    val onClick: () -> Unit
)