package com.feedbackbulb.libs.core

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() = runTest {
        assertTrue(Greeting().greeting().contains("iOS"), "Check iOS is mentioned")
    }
}