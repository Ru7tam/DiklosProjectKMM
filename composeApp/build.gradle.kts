import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import com.android.build.api.dsl.ManagedVirtualDevice
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                    freeCompilerArgs.add("-Xjdk-release=${JavaVersion.VERSION_1_8}")
                }
            }
        }
        //https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-test.html
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        instrumentedTestVariant {
            sourceSetTree.set(KotlinSourceSetTree.test)
            dependencies {
                debugImplementation(libs.androidx.testManifest)
                implementation(libs.androidx.junit4)
            }
        }
    }

    jvm()

//    wasmJs {
//        browser()
//        binaries.executable()
//    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.material)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            
            implementation(libs.composeImageLoader)
            implementation(libs.kotlinx.coroutines.core)
                        implementation(libs.ktor.core)
                        implementation(libs.kotlinx.serialization.json)
                        implementation(libs.kotlinx.datetime)
                        implementation(libs.multiplatformSettings)
                        
                        implementation(libs.compose.viewmodel)
                        implementation(libs.compose.navigation)
                    }
            
                    commonTest.dependencies {
                        implementation(kotlin("test"))
                        @OptIn(ExperimentalComposeLibrary::class)
                        implementation(compose.uiTest)
                        implementation(libs.kotlinx.coroutines.test)
                    }
            
                    androidMain.dependencies {
                        implementation(compose.uiTooling)
                        implementation(libs.androidx.activityCompose)
                        implementation(libs.kotlinx.coroutines.android)
                        implementation(libs.ktor.client.okhttp)
                        implementation(libs.ktor.client.content.negotiation)
                        implementation(libs.ktor.serialization.kotlinx.json)
                    }
            
                    jvmMain.dependencies {
                        implementation(compose.desktop.currentOs)
                        implementation(libs.kotlinx.coroutines.swing)
                        implementation(libs.ktor.client.okhttp)
                    }
            
                    iosMain.dependencies {
                        implementation(libs.ktor.client.darwin)
                    }
            
                }
            }
            
            android {
                namespace = "org.company.app"
                compileSdk = 34
            
                defaultConfig {
                    minSdk = 24
                    targetSdk = 34
            
                    applicationId = "org.company.app.androidApp"
                    versionCode = 1
                    versionName = "1.0.0"
            
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                sourceSets["main"].apply {
                    manifest.srcFile("src/androidMain/AndroidManifest.xml")
                    res.srcDirs("src/androidMain/res")
                }
                //https://developer.android.com/studio/test/gradle-managed-devices
                @Suppress("UnstableApiUsage")
                testOptions {
                    managedDevices.devices {
                        maybeCreate<ManagedVirtualDevice>("pixel5").apply {
                            device = "Pixel 5"
                            apiLevel = 34
                            systemImageSource = "aosp"
                        }
                    }
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
                buildFeatures {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.11"
                }
            }
            
            compose.desktop {
                application {
                    mainClass = "MainKt"
            
                    nativeDistributions {
                        targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                        packageName = "org.company.app.desktopApp"
                        packageVersion = "1.0.0"
                    }
                }
            }
            
            compose.experimental {
                web.application {}
            }
            