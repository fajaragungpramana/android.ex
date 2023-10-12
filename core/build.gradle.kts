plugins {
    id(Plugin.LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.KOTLIN_KAPT)
    id(Plugin.HILT)
}

android {
    namespace = "com.github.fajaragungpramana.ex.core"
    compileSdk = Version.SDK

    defaultConfig {
        minSdk = Version.MIN_SDK

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

    api(platform(Dependency.Firebase.BOM))
    api(Dependency.Firebase.ANALYTIC)

    implementation(Dependency.Google.HILT)
    kapt(Dependency.Google.HILT_COMPILER)

}

kapt {
    correctErrorTypes = true
}