plugins {
    id(Plugin.APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.KOTLIN_KAPT)
    id(Plugin.GOOGLE_SERVICE)
    id(Plugin.HILT)
}

android {
    namespace = "com.github.fajaragungpramana.ex"
    compileSdk = Version.SDK

    defaultConfig {
        applicationId = "com.github.fajaragungpramana.ex"
        minSdk = Version.MIN_SDK
        targetSdk = Version.SDK
        versionCode = Version.APP_CODE
        versionName = Version.APP_NAME

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
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(Module.LIBRARY_CORE))
    implementation(project(Module.LIBRARY_WIDGET))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME_KTX)
    implementation(Dependency.AndroidX.NAVIGATION_COMPOSE)

    implementation(Dependency.Google.HILT)
    kapt(Dependency.Google.HILT_COMPILER)

    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(platform(Dependency.AndroidX.COMPOSE_BOM))
    androidTestImplementation(Dependency.AndroidTest.COMPOSE_UI_TEST_JUNIT)
    debugImplementation(Dependency.Debug.COMPOSE_UI_TOOLING)
    debugImplementation(Dependency.Debug.COMPOSE_UI_TEST_MANIFEST)

}