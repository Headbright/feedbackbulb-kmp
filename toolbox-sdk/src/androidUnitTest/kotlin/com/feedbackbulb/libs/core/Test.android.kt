package com.feedbackbulb.libs.toolbox

import com.feedbackbulb.libs.core.FeedbackSDKClient
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testToolboxSubmittingFeedback() = runTest {
        val client = FeedbackSDKClient("01b7f627-37c0-43f8-8815-2d730f55134b")
        client.sendFeedback(
            "This is a test feedback from Feedback SDK for Kotlin Multiplatform send from Android",
            mapOf("example" to "Kotlin Multiplatform")
        )
    }
}