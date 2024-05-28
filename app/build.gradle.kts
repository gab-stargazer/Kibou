plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.safeargs)
}

android {
    namespace = "com.lelestacia.kibou"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lelestacia.kibou"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("debug")
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    splits {
        abi {
            isEnable = true
            reset()
            include("x86", "x86_64", "armeabi-v7a", "arm64-v8a")
            isUniversalApk = false
        }
    }

}

dependencies {

    //=====Common=====
    implementation(projects.core.common)
    implementation(projects.core.theme)

    //=====Coil=====
    implementation(libs.coil)

    //=====Compose=====
    implementation(platform(libs.compose.bom))
    androidTestImplementation(platform(libs.compose.bom))
    implementation(libs.compose.activity)
    implementation(libs.compose.material.design)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphic)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.icon)
    implementation(libs.compose.font)
    implementation(libs.compose.icons.font.awesome)

    //=====Koin=====
    implementation(platform(libs.koin.annotation.bom))
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.annotation)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.coroutine)
    implementation(libs.koin.compose)
    ksp(libs.koin.compiler)

    //=====Ktx=====
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    //=====Navigation=====
    implementation(libs.navigation)

    //=====Serialization=====
    implementation(libs.kotlin.serialization)

    //=====Ui Test=====
    androidTestImplementation(libs.ui.test.espresso.core)
    androidTestImplementation(libs.ui.test.android.junit)
    androidTestImplementation(libs.ui.test.compose.junit)
    androidTestImplementation(libs.ui.test.compose.manifest)

    //=====Testing=====
    testImplementation(libs.junit)
    testRuntimeOnly(libs.junit.engine)
    testImplementation(libs.junit.parameterized)
    testImplementation(libs.test.junit.old)
    testRuntimeOnly(libs.junit.vintage.engine)

    //=====Timber=====
    implementation(libs.timber)

    //=====ViewModel=====
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.viewmodel.compose)
}