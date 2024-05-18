import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
    signing
}

publishing {
    // Configure all publications
    publications.withType<MavenPublication> {
        // Stub javadoc.jar artifact
        artifact(tasks.register("${name}JavadocJar", Jar::class) {
            archiveClassifier.set("javadoc")
            archiveAppendix.set(this@withType.name)
        })

        // Provide artifacts information required by Maven Central
        pom {
            name.set("Feedbackbulb SDK")
            description.set("Feedbackbulb is an interactive feedback framework for apps and websites.")
            url.set("https://feedbackbulb.com/")

            licenses {
                license {
                    name.set("BSD-3-clause")
                    url.set("https://opensource.org/license/BSD-3-clause")
                }
            }
            developers {
                developer {
                    id.set("Konstantin")
                    name.set("Konstantin")
                    organization.set("Headbright Group")
                    organizationUrl.set("https://headbright.eu/")
                }
            }
            scm {
                url.set("https://github.com/Headbright/feedbackbulb-kmp")
            }
        }
    }
}

signing {
    if (project.hasProperty("signing.gnupg.keyName")) {
        useGpgCmd()
        sign(publishing.publications)
    }
}

