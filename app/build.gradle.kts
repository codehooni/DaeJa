plugins {
    id("com.android.application")
}

android {
    namespace = "com.app.daeja"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.daeja"
        minSdk = 24
        targetSdk = 33
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

    buildFeatures{
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("../libs/com.skt.Tmap_1.75.jar"))
    implementation("androidx.navigation:navigation-fragment:2.7.5")
    implementation("androidx.navigation:navigation-ui:2.7.5")
    implementation("com.github.bumptech.glide:glide:4.13.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //network
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-json:2.9.0")

    //androidTestImplementation("androidx.test.ext:junit:1.1.5")

    //implementation("com.github.majorkik:SparKLineLayout:1.0.1")
    //implementation("com.github. ome450901:SimpleRatingBar: 1.5.1")
    //implementation("com.google.android material:material:1.4.0")
    //implementation("com.google.android.material:material:1.11.0-beta01")

}