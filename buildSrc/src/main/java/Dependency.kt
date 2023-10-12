object Dependency {

    object AndroidTest {
        const val JUNIT = "androidx.test.ext:junit:1.1.5"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.5.1"
        const val COMPOSE_UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:1.12.0"
        const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2"
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:1.8.0"

        const val COMPOSE_HILT = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:2.7.4"

        const val COMPOSE_BOM = "androidx.compose:compose-bom:2023.10.00"
        const val COMPOSE_UI = "androidx.compose.ui:ui"
        const val COMPOSE_UI_GRAPHIC = "androidx.compose.ui:ui-graphics"
        const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
        const val COMPOSE_MATERIAL = "androidx.compose.material3:material3"
    }

    object Debug {
        const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling"
        const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest"
    }

    object Firebase {
        const val BOM = "com.google.firebase:firebase-bom:32.3.1"
        const val ANALYTIC = "com.google.firebase:firebase-analytics-ktx"
    }

    object Google {
        const val HILT = "com.google.dagger:hilt-android:${Version.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Version.HILT}"
    }

    object Test {
        const val JUNIT = "junit:junit:4.13.2"
    }

}