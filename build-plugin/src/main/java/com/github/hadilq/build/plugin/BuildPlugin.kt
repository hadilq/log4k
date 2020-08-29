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
package com.github.hadilq.build.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.*

class BuildPlugin : Plugin<Project> {

  override fun apply(target: Project) = target.setup()
}

const val SNAPSHOT = "-SNAPSHOT"

private const val VERSION_ANDROIDX_APPCOMPAT = "1.2.0"
private const val VERSION_CONSTRAINT_LAYOUT = "2.0.0"

private const val VERSION_JUNIT = "4.12"

const val VERSION_JACOCO = "0.8.5"

const val GROUP_ID = "com.github.hadilq"
const val LIB_VERSION = "2.1.0$SNAPSHOT"

const val VERSION_COMPILE_SDK = 29
const val VERSION_MIN_SDK = 15
const val VERSION_TARGET_SDK = 29

const val KOTLIN_TEST_ANNOTATIONS = "test-junit"
const val KOTLIN_TEST_ANNOTATIONS_COMMON = "test-annotations-common"
const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:$VERSION_ANDROIDX_APPCOMPAT"
const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:$VERSION_CONSTRAINT_LAYOUT"

const val JUNIT = "junit:junit:$VERSION_JUNIT"
