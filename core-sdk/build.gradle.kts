import com.vanniktech.maven.publish.SonatypeHost
//import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.publish)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    targetHierarchy.default()

    androidTarget {
        publishLibraryVariants("release", "debug")

        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

//    val xcframeworkName = "FeedbackbulbCoreSDK"
//    val xcf = XCFramework(xcframeworkName)
//
//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64(),
//        watchosX64(),
//        watchosArm64(),
//        watchosSimulatorArm64(),
//        macosX64(),
//        macosArm64(),
//        tvosX64(),
//        tvosArm64(),
//        tvosSimulatorArm64(),
//    ).forEach {
//        it.binaries.framework {
//            baseName = xcframeworkName
//            binaryOption("bundleId", "com.feedbackbulb.${xcframeworkName}")
//            xcf.add(this)
//            isStatic = true
//        }
//    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        watchosX64(),
        watchosArm64(),
        watchosSimulatorArm64(),
        macosX64(),
        macosArm64(),
        tvosX64(),
        tvosArm64(),
        tvosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "core-sdk"
            isStatic = true
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.serialization.kotlinx.protobuf)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.kotlinx.coroutines.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)
        }
    }

    task("testClasses")
}

android {
    namespace = "com.feedbackbulb"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

mavenPublishing {
    coordinates(
        groupId = "com.feedbackbulb",
        artifactId = "core-sdk",
        version = "0.0.4"
    )

    // Configure POM metadata for the published artifact
    pom {
        name.set("Feedbackbulb SDK")
        description.set("Feedbackbulb is an interactive feedback framework for apps and websites.")
        url.set("https://feedbackbulb.com/")
        inceptionYear.set("2024")

        licenses {
            license {
                name.set("BSD-3-clause")
                url.set("https://opensource.org/license/BSD-3-clause")
            }
        }

        // Specify developers information
        developers {
            developer {
                id.set("iamkonstantin")
                name.set("Konstantin")
                organization.set("Headbright Group")
                organizationUrl.set("https://headbright.eu/")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/Headbright/feedbackbulb-kmp")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}