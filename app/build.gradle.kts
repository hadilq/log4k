/**
 * Copyright 2019 Hadi Lashkari Ghouchani

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
  id("com.android.application")
  kotlin("android")
  kotlin("android.extensions")
  kotlin("kapt")
  id("com.github.hadilq.build-plugin")
}

android {
  compileSdkVersion(VERSION_COMPILE_SDK)
  defaultConfig {
    applicationId = "com.hadilq.log4k.sample"
    minSdkVersion(VERSION_MIN_SDK)
    targetSdkVersion(VERSION_TARGET_SDK)
    versionCode = 1
    versionName = "1.0"
  }
}

dependencies {
  implementation(project(":log4k"))
//    implementation("$GROUP_ID:log4k-android:${LIB_VERSION}")

  implementation(ANDROIDX_APPCOMPAT)
  implementation(CONSTRAINT_LAYOUT)
}
