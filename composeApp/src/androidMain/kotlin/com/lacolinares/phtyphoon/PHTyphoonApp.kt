package com.lacolinares.phtyphoon

import android.app.Application
import com.lacolinares.phtyphoon.di.initKoin
import org.koin.android.ext.koin.androidContext

class PHTyphoonApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@PHTyphoonApp)
        }
    }
}