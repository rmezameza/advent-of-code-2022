import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
/*
 * This Kotlin/JVM buildscript was given to me by my great colluege Raphael
 * https://github.com/RaphaelTarita
 */


plugins {
    kotlin("jvm") version "1.7.21"
}

group = "com.rmezameza"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // For libraries
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}