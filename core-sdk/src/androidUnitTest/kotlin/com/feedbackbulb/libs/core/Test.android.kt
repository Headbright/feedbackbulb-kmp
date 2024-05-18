package com.feedbackbulb.libs.core

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() = runTest {
        val result = Greeting().greeting()
        kotlin.test.assertTrue(result.isNotEmpty())
    }
}