package com.teamx.vibecare

import android.app.Application
import com.teamx.vibecare.utils.Ktr

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Ktr.init(applicationContext)
    }
}