plugins {
    id("com.android.application")
    // Supprimez le plugin Kotlin car nous allons utiliser Java
    // id("org.jetbrains.kotlin.android") --> Supprimez cette ligne
}

android {
    namespace = "com.example.app_psy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.app_psy"
        minSdk = 21
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
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // Supprimez les fonctionnalités de Jetpack Compose
    // buildFeatures {
    //     compose = true
    // }
    // composeOptions {
    //     kotlinCompilerExtensionVersion = "1.5.1"
    // }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1") // `ktx` est une extension Kotlin, mais nous l'utiliserons pour AndroidX. Vous pouvez le remplacer par la version non `ktx` si nécessaire.
    implementation("androidx.lifecycle:lifecycle-runtime:2.6.1")
    implementation("androidx.activity:activity:1.7.2")

    // Utilisez la bibliothèque standard Material
    implementation("com.google.android.material:material:1.9.0")

    // Material CalendarView pour afficher le calendrier
    implementation("com.prolificinteractive:material-calendarview:1.4.3")

    // Dépendances de test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
