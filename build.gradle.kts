@file:Suppress("SpellCheckingInspection")

// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
	alias(libs.plugins.androidApplication) apply false
	alias(libs.plugins.kotlinAndroid) apply false

	// Google services Gradle plugin
	id("com.google.gms.google-services") version "4.4.2" apply false
	// Crashlytics Gradle plugin
	id("com.google.firebase.crashlytics") version "3.0.1" apply false
	// Performance Monitoring Gradle plugin
	id("com.google.firebase.firebase-perf") version "1.4.2" apply false
}
true // Needed to make the Suppress annotation work for the plugins block