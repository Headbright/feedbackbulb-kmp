package com.feedbackbulb.libs.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform