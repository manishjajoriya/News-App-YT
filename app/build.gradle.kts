plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  id("com.ncorti.ktfmt.gradle") version ("0.22.0")
  id("com.google.dagger.hilt.android")
  id("com.google.devtools.ksp")
  kotlin("plugin.serialization") version "2.0.21"
}

allprojects {
  apply(plugin = "com.ncorti.ktfmt.gradle")
  ktfmt { // 1
    googleStyle() // 2
  }
}

android {
  namespace = "com.manishjajoriya.kabar"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.manishjajoriya.kabar"
    minSdk = 24
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions { jvmTarget = "11" }
  buildFeatures { compose = true }
}

dependencies {
  val nav_version = "2.9.0"

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)

  // Splash Screen
  implementation("androidx.core:core-splashscreen:1.0.0")

  // Navigation
  implementation("androidx.navigation:navigation-compose:$nav_version")

  // DataStore Preferences
  implementation("androidx.datastore:datastore-preferences:1.1.7")

  // Dagger Hilt
  implementation("com.google.dagger:hilt-android:2.56.2")
  ksp("com.google.dagger:hilt-android-compiler:2.56.2")
  implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

  // System UI
  implementation("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")

  // Retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")

  // Paging
  implementation("androidx.paging:paging-runtime:3.2.1")

  // Coil Ima
  implementation("io.coil-kt.coil3:coil-compose:3.2.0")
}
