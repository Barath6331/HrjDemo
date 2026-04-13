package com.example.hrjdemo.ui.theme

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ApplicationClass : Application() {

    companion object {
        lateinit var context: ApplicationClass
            private set
    }

    override fun onCreate() {
        super.onCreate()

        context = this

        // Disable dark mode (optional)
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        )
    }
}