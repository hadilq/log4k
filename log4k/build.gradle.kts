/**
 * Copyright 2020 Hadi Lashkari Ghouchani

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.github.hadilq.build.plugin.*

plugins {
  id("kotlin-multiplatform")
  id("com.android.library")
  id("com.github.hadilq.build-plugin")
}

android {
  compileSdkVersion(VERSION_COMPILE_SDK)

  defaultConfig {
    targetSdkVersion(VERSION_TARGET_SDK)
    minSdkVersion(VERSION_MIN_SDK)
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }

  compileOptions {
    sourceCompatibility(JavaVersion.VERSION_1_8)
    targetCompatibility(JavaVersion.VERSION_1_8)
  }
}

kotlin {
  android {
    publishLibraryVariants = listOf("release")
  }
  jvm {
    compilations.all {
      kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
      }
    }
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation(kotlin(KOTLIN_STDLIB_COMMON))
      }
    }

    commonTest {
      dependencies {
        implementation(kotlin(KOTLIN_TEST_COMMON))
        implementation(kotlin(KOTLIN_TEST_ANNOTATIONS_COMMON))
        implementation(MOCKK_COMMON)
      }
    }

    val jvmMain by getting {
      dependencies {
        implementation(kotlin(KOTLIN_STDLIB))
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(JUNIT)
      }
    }

    val androidMain by getting {
      dependsOn(jvmMain)
      dependencies {
        implementation(kotlin(KOTLIN_STDLIB))
      }
    }

    val androidTest by getting {
      dependencies {
        implementation(JUNIT)
        implementation(MOCKITO)
      }
    }
  }
}

/**
 * To make android library be available for all variants.
 *
 * see https://docs.gradle.org/current/userguide/publishing_gradle_module_metadata.html#sub:disabling-gmm-publication
 */
tasks.withType<GenerateModuleMetadata> {
  enabled = false
}

setupJacoco()
setupPublication()