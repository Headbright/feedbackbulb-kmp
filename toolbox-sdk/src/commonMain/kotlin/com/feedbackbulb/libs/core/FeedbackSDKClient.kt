package com.feedbackbulb.libs.core

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json


/**
 * This class represents the Feedback SDK client.
 * It is used to send feedback to the FeedbackBulb service.
 *
 * @property appKey The application key which will receive feedback reports. You can obtain it from the Feedbackbulb dashboard.
 */
public class FeedbackSDKClient(public val appKey: String) {
    // HttpClient used for making HTTP requests.
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    /**
     * Sends feedback to the Feedbackbulb service.
     * It makes a POST request to the FeedbackBulb API with the feedback content and attributes.
     *
     * @param content The content of the feedback.
     * @param attributes Additional attributes for the feedback. Default is an empty map.
     */
    public suspend fun sendFeedback(content: String, attributes: Map<String, String> = emptyMap()) {
        // post value to https://feedbackbulb.com/api/values

        val report = FeedbackbulbReport(appKey, content, attributes)
        val value = FeedbackbulbValue(report)

        client.post("https://feedbackbulb.com/api/values") {
            contentType(ContentType.Application.Json)
            setBody(value)
        }
    }
}