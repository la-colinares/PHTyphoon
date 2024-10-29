package com.lacolinares.phtyphoon

import android.os.Build
import com.lacolinares.phtyphoon.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()