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

setupJacoco()
setupPublication()

android {
  compileSdkVersion(VERSION_COMPILE_SDK)

  defaultConfig {
    targetSdkVersion(VERSION_TARGET_SDK)
    minSdkVersion(VERSION_MIN_SDK)
  }
  val main by sourceSets.getting {
    manifest.srcFile("src/androidMain/AndroidManifest.xml")
  }

  compileOptions {
    sourceCompatibility(JavaVersion.VERSION_1_8)
    targetCompatibility(JavaVersion.VERSION_1_8)
  }
}

kotlin {
  android {
    publishAllLibraryVariants()
  }
  jvm {
    compilations.all {
      kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
      }
    }
  }
  js {
    browser()
    nodejs()
  }
  ios()
  watchos()
  tvos()
  macosX64()
  linuxArm64()
  linuxX64()
  mingwX64()
  mingwX86()

  sourceSets {
    val commonMain by getting {
      dependencies {
      }
    }

    val commonTest by getting {
      dependencies {
        implementation(kotlin(KOTLIN_TEST_ANNOTATIONS_COMMON))
      }
    }

    val jsMain by getting {
      dependencies {
      }
    }

    val jsTest by getting {
      dependencies {
        implementation(kotlin(KOTLIN_TEST_ANNOTATIONS_JS))
      }
    }

    val jvmMain by getting {
      dependencies {
        implementation(kotlin(KOTLIN_REFLECT))
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(kotlin(KOTLIN_TEST_ANNOTATIONS_JVM))
        implementation(JUNIT)
      }
    }

    val androidMain by getting {
      dependsOn(jvmMain)
      dependencies {
      }
    }

    val androidTest by getting {
      dependencies {
        implementation(kotlin(KOTLIN_TEST_ANNOTATIONS_JVM))
        implementation(JUNIT)
      }
    }

    val nativeMain by creating {
      dependsOn(commonMain)
    }

    val iosMain by getting {
      dependencies {
        dependsOn(nativeMain)
      }
    }

    val watchosMain by getting {
      dependencies {
        dependsOn(nativeMain)
      }
    }

    val tvosMain by getting {
      dependencies {
        dependsOn(nativeMain)
      }
    }

    val macosX64Main by getting {
      dependencies {
        dependsOn(nativeMain)
      }
    }

    val linuxArm64Main by getting {
      dependencies {
        dependsOn(nativeMain)
      }
    }

    val linuxX64Main by getting {
      dependencies {
        dependsOn(nativeMain)
      }
    }

    val mingwX64Main by getting {
      dependencies {
        dependsOn(nativeMain)
      }
    }

    val mingwX86Main by getting {
      dependencies {
        dependsOn(nativeMain)
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
