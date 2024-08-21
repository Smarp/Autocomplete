plugins {
    id("com.android.library")
    id("kotlin-android") // Just for publisher autodocs
    id("maven-publish")
}

android {
    setCompileSdkVersion(property("compileSdkVersion") as Int)

    defaultConfig {
        setMinSdkVersion(property("minSdkVersion") as Int)
        setTargetSdkVersion(property("targetSdkVersion") as Int)
        versionName = "1.1.1"
    }

    buildTypes {
        get("release").consumerProguardFile("proguard-rules.pro")
    }
}

dependencies {
    api("androidx.recyclerview:recyclerview:1.1.0")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.Smarp"
            artifactId = "Autocomplete"
            version = "1.1.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
