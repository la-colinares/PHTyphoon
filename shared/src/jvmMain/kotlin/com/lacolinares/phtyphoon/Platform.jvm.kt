package com.lacolinares.phtyphoon

import com.lacolinares.phtyphoon.Platform

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()