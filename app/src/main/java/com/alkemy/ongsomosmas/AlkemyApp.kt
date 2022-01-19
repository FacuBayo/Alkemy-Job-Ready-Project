package com.alkemy.ongsomosmas

import android.app.Application
import cat.ereza.customactivityoncrash.config.CaocConfig
import com.alkemy.ongsomosmas.ui.login.LoginActivity
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AlkemyApp: Application(){

    override fun onCreate() {
        super.onCreate()
        crashConfig()
    }

    private fun crashConfig() {
        CaocConfig.Builder.create()
            .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
            .showErrorDetails(false)
            .minTimeBetweenCrashesMs(2000)
            .logErrorOnRestart(false)
            .errorDrawable(R.drawable.logo_somos_mas)
            .restartActivity(LoginActivity::class.java)
            .apply()
    }
}