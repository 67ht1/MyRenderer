import com.launchers_plugin.renderer.buildscript.buildEnvs
import com.launchers_plugin.renderer.buildscript.buildJsonValue
import com.launchers_plugin.renderer.buildscript.nativePath
import com.launchers_plugin.renderer.buildscript.renderer

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.github.ZalithLauncher.RendererPlugin-v2:dsl:1.0.1")
    }
}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply(plugin = "com.launchers_plugin.renderer.dsl")

android {
    namespace = "dev.myrenderer.plugin"
    compileSdk = 35
    ndkVersion = "27.2.12479018"

    defaultConfig {
        applicationId = "dev.myrenderer.plugin"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
        ndk {
            abiFilters += listOf("arm64-v8a")
        }
        externalNativeBuild {
            cmake {
                arguments += listOf("-DANDROID_STL=c++_static")
            }
        }
    }

    buildFeatures {
        resValues = true
    }

    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            resValue("string", "app_name", "MyRenderer Debug")
        }
        release {
            isMinifyEnabled = false
            resValue("string", "app_name", "MyRenderer")
        }
        configureEach {
            resValue("string", "config", buildJsonValue {
                renderer(
                    displayName = "MyRenderer",
                    rendererId = "opengles3",
                    rendererGLPath = nativePath("libmobileglues.so"),
                    rendererEGLPath = nativePath("libmobileglues.so"),
                    dlopenLibPaths = emptyList(),
                    env = buildEnvs {
                        normal("LIBGL_ES", "3")
                        normal("MOBILEGL_BACKEND_TYPE", "DirectGLES")
                    },
                    minMCVer = null,
                    maxMCVer = null
                )
            })
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    jvmToolchain(17)
}
