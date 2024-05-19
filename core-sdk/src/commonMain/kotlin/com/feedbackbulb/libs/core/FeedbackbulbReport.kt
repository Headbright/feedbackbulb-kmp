package com.feedbackbulb.libs.core

import kotlinx.serialization.Serializable

@Serializable
data class FeedbackbulbReport(
    val key: String,
    val content: String,
    val attributes: Map<String, String>
)
