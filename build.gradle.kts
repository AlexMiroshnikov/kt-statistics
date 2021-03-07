import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    id("tech.formatter-kt.formatter") version "0.7.3"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("jacoco")
}

group = "me.ilex"
version = "0.0.1-dev"

repositories { mavenCentral() }

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation(kotlin("script-runtime"))
}

tasks.test { useJUnitPlatform() }

tasks.withType<KotlinCompile>() { kotlinOptions.jvmTarget = "11" }

tasks.ktlintFormat { dependsOn(tasks.formatKotlin) }

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        csv.isEnabled = true
        html.isEnabled = true
    }
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)

    violationRules {
        rule {
            element = "CLASS"
            limit {
                value = "COVEREDRATIO"
                minimum = 1.0.toBigDecimal()
            }
            excludes = listOf("me.ilex.statistics.ModeKt")
        }
        rule {
            element = "CLASS"
            limit {
                value = "COVEREDRATIO"
                minimum = 0.96.toBigDecimal()
            }
            includes = listOf("me.ilex.statistics.ModeKt")
        }
    }
}
