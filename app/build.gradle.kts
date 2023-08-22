plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.wecod"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.wecod"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")



    testImplementation("junit:junit:4.13.2")
    // Test coroutine dispatcher
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    // ComposeRule
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3")

    // For instrumented tests.
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.38.1")
    // ...with Kotlin.
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.38.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Coroutines
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.activity:activity-ktx:1.7.2")

    // Moshi
    // implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    ksp("com.squareup.retrofit2:converter-moshi:2.9.0")

    // Kotlin Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.6.0")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:2.6.0")

    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Coil - Images
    implementation("io.coil-kt:coil:2.1.0")
    implementation("io.coil-kt:coil-compose:2.1.0")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")

    // Mockito
    testImplementation("org.mockito:mockito-core:2.19.0")

    // Dependency injection with Hilt
    implementation("com.google.dagger:hilt-android:2.47")
    implementation("com.google.dagger:dagger:2.47")
    kapt("com.google.dagger:hilt-compiler:2.47")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))
    implementation("com.google.firebase:firebase-messaging-ktx:23.2.1")}
