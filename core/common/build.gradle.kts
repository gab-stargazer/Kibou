plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.lelestacia.kibou.common"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    //=====Arrow=====
    implementation(platform(libs.arrow.bom))
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    //=====Koin=====
    implementation(platform(libs.koin.annotation.bom))
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.annotation)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.coroutine)
    ksp(libs.koin.compiler)

    //=====Serialization=====
    implementation(libs.kotlin.serialization)

    //=====Timber=====
    implementation(libs.timber)
}