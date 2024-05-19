# Feedbackbulb SDK for Kotlin Multiplatform

This is the Feedbackbulb SDK for Kotlin Multiplatform.
It is a library that allows you to easily integrate Feedbackbulb into your Kotlin project.

⚠️ This is a work in progress and doesn't support all features of the Feedbackbulb API yet. If you encounter a bug or need a specific feature, please open an issue or a pull request.


Currently supported platforms are:

- Kotlin/JVM
- Android
- iOS


## Getting started

### Add the dependency

The library is available directly from [Maven Central](https://central.sonatype.com/artifact/com.feedbackbulb/core-sdk. Add the following to your `build.gradle.kts` file:

```kotlin
implementation("com.feedbackbulb:core-sdk:X.X.X")
```

(replace `X.X.X` with the latest version)


### Initialize the SDK

Begin by obtaining an app key from the [Feedbackbulb dashboard](https://app.feedbackbulb.com/). Then, initialize the SDK with the app key:

```kotlin
val client= FeedbackSDKClient("YOUR_APP_KEY")
```

### Send feedback

To send feedback, use the `sendFeedback` method:

```kotlin
client.sendFeedback("This is a test feedback from Feedback SDK for Kotlin Multiplatform")
// or 
client.sendFeedback("This is a test feedback from Feedback SDK for Kotlin Multiplatform", mapOf("example" to "Kotlin Multiplatform"))
```


## Local development

The following are notes for local development of the SDK and publishing updates.

Create or update gradle.properties file in the root of the project with the following content:

```
signing.keyId=...
signing.password=...
signing.secretKeyRingFile=....
mavenCentralUsername=...
mavenCentralPassword=...
```

DO NOT CHECK THIS IN!


To publish a new version, run `./gradlew publishAndReleaseToMavenCentral --no-configuration-cache`