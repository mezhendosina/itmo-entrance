plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ru.mezhendosina.itmo.enterance"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.mezhendosina.itmo.enterance"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("com.google.android.gms:play-services-wearable:18.1.0")
    implementation("androidx.percentlayout:percentlayout:1.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation( "androidx.compose.material3:material3-window-size-class:1.1.2")
    implementation("androidx.wear.compose:compose-foundation:1.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.wear.tiles:tiles:1.2.0")
    implementation("androidx.wear.tiles:tiles-material:1.2.0")
    implementation("com.google.android.horologist:horologist-compose-tools:0.1.5")
    implementation("com.google.android.horologist:horologist-tiles:0.1.5")
    implementation("androidx.wear.watchface:watchface-complications-data-source-ktx:1.1.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    wearApp(project(":wear"))

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    implementation("io.github.g0dkar:qrcode-kotlin-android:3.3.0")


    implementation("androidx.wear:wear:1.3.0")

    // Add support for wearable specific inputs
    implementation("androidx.wear:wear-input:1.1.0")
    implementation("androidx.wear:wear-input-testing:1.1.0")

    // Use to implement wear ongoing activities
    implementation("androidx.wear:wear-ongoing:1.0.0")

    // Use to implement support for interactions from the Wearables to Phones
    implementation("androidx.wear:wear-phone-interactions:1.0.1")
    // Use to implement support for interactions between the Wearables and Phones
    implementation("androidx.wear:wear-remote-interactions:1.0.0")

    //data store
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")


    // hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

}
kapt {
    correctErrorTypes = true
}