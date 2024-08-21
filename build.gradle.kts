buildscript {

    extra["minSdkVersion"] = 14
    extra["compileSdkVersion"] = 29
    extra["targetSdkVersion"] = 29
    extra["kotlinVersion"] = "1.3.61"

    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        val kotlinVersion = property("kotlinVersion") as String
        classpath("com.android.tools.build:gradle:3.6.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(buildDir)
}
