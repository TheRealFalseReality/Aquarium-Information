@file:Suppress("SpellCheckingInspection")

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)

    // Google services Gradle plugin
    id("com.google.gms.google-services")
    // Crashlytics Gradle plugin
    id("com.google.firebase.crashlytics")
    // Performance Monitoring Gradle plugin
    id("com.google.firebase.firebase-perf")
}

val versionMajor = 2
val versionMinor = 0
val versionPatch = 10

android {
    namespace = "cca.capitalcityaquatics.aquariuminfo"
    compileSdk = 34

    defaultConfig {
        applicationId = "cca.capitalcityaquatics.aquariuminfo"
        minSdk = 29
        targetSdk = 34
        versionCode = versionMajor * 10000 + versionMinor * 100 + versionPatch
        versionName = "$versionMajor.$versionMinor.$versionPatch"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue(
                type = "string",
                name = "appVersion",
                value = "${defaultConfig.versionName}"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        debug {
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    // Jetpack Compose Navigation
    implementation(libs.androidx.navigation.compose)

    // Firebase BoM
    implementation(platform(libs.firebase.bom))
    // Firebase SDK for Google Analytics
    implementation(libs.firebase.analytics.ktx)
    // Crashlytics and Analytics libraries
    implementation(libs.firebase.crashlytics.ktx)
    implementation(libs.google.firebase.analytics.ktx)
    // Performance Monitoring library
    implementation(libs.firebase.perf.ktx)

    // Predicitive Back Gesture
    implementation(libs.androidx.activity.ktx)

    // WindowSizeClass
    implementation("androidx.compose.material3:material3-window-size-class:1.2.1")
}