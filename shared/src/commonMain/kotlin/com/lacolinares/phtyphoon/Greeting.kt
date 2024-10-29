package com.lacolinares.phtyphoon

class Greeting {
    private val platform = com.lacolinares.phtyphoon.getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}