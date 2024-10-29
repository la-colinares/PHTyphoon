package com.lacolinares.phtyphoon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform