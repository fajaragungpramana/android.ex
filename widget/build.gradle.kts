plugins {
    id(Plugin.LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.KOTLIN_KAPT)
}

android {
    namespace = "com.github.fajaragungpramana.ex.widget"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {

    api(Dependency.AndroidX.ACTIVITY_COMPOSE)

    api(platform(Dependency.AndroidX.COMPOSE_BOM))
    api(Dependency.AndroidX.COMPOSE_UI)
    api(Dependency.AndroidX.COMPOSE_UI_GRAPHIC)
    api(Dependency.AndroidX.COMPOSE_UI_TOOLING_PREVIEW)
    api(Dependency.AndroidX.COMPOSE_MATERIAL)
    api(Dependency.AndroidX.COMPOSE_MATERIAL_ICON_EXTENDED)

}

kapt {
    correctErrorTypes = true
}