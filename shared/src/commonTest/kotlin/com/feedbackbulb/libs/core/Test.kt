package com.feedbackbulb.libs.core

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() = runTest {
        assertTrue(Greeting().greeting().contains("Ktor"), "Check 'Ktor' is mentioned")
    }
}