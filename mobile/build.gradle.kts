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

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding.enable = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation("com.google.android.gms:play-services-wearable:18.0.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    wearApp(project(":wear"))

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")



    // Add support for wearable specific inputs
    implementation("androidx.wear:wear-input:1.1.0")
    implementation("androidx.wear:wear-input-testing:1.1.0")

    // Use to implement wear ongoing activities
    implementation("androidx.wear:wear-ongoing:1.0.0")

    // Use to implement support for interactions from the Wearables to Phones
    implementation("androidx.wear:wear-phone-interactions:1.0.1")
    // Use to implement support for interactions between the Wearables and Phones
    implementation("androidx.wear:wear-remote-interactions:1.0.0")
}
//
//kapt {
//    correctErrorTypes = true
//}