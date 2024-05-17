package com.feedbackbulb.libs.core

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() = runTest {
        assertTrue("Check iOS is mentioned", Greeting().greeting().contains("Ktor"))
    }
}