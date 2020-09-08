/**
 * Copyright 2018 Hadi Lashkari Ghouchani

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
package com.log4k

import com.log4k.util.FakeLog4k
import com.log4k.util.LogData
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoggerConfigTest {
  @Test
  fun testVerboseWithoutAnnotation() {
    val log4k = FakeLog4k()
    Any().run { v(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = KOTLIN_ANY),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testVerboseWithAnnotation() {
    val log4k = FakeLog4k()
    val any = @LoggerConfig(
      enable = false,
      tag = ANY_TAG,
      owners = [ANY_OWNER]
    ) object : Any() {}
    any.run { v(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(
          enable = false,
          tag = ANY_TAG,
          owners = arrayOf(ANY_OWNER)
        ),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testDebugWithoutAnnotation() {
    val log4k = FakeLog4k()
    Any().run { d(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = KOTLIN_ANY),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testDebugWithAnnotation() {
    val log4k = FakeLog4k()
    val any = @LoggerConfig(
      enable = false,
      tag = ANY_TAG,
      owners = [ANY_OWNER]
    ) object : Any() {}
    any.run { d(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(
          enable = false,
          tag = ANY_TAG,
          owners = arrayOf(ANY_OWNER)
        ),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testInfoWithoutAnnotation() {
    val log4k = FakeLog4k()
    Any().run { v(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = KOTLIN_ANY),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testInfoWithAnnotation() {
    val log4k = FakeLog4k()
    val any = @LoggerConfig(
      enable = false,
      tag = ANY_TAG,
      owners = [ANY_OWNER]
    ) object : Any() {}
    any.run { i(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(
          enable = false,
          tag = ANY_TAG,
          owners = arrayOf(ANY_OWNER)
        ),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testWarnWithoutAnnotation() {
    val log4k = FakeLog4k()
    Any().run { w(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = KOTLIN_ANY),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testWarnWithAnnotation() {
    val log4k = FakeLog4k()
    val any = @LoggerConfig(
      enable = false,
      tag = ANY_TAG,
      owners = [ANY_OWNER]
    ) object : Any() {}
    any.run { w(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(
          enable = false,
          tag = ANY_TAG,
          owners = arrayOf(ANY_OWNER)
        ),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testErrorWithoutAnnotation() {
    val log4k = FakeLog4k()
    Any().run { e(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = KOTLIN_ANY),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testErrorWithAnnotation() {
    val log4k = FakeLog4k()
    val any = @LoggerConfig(
      enable = false,
      tag = ANY_TAG,
      owners = [ANY_OWNER]
    ) object : Any() {}
    any.run { e(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(
          enable = false,
          tag = ANY_TAG,
          owners = arrayOf(ANY_OWNER)
        ),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testAssertWithoutAnnotation() {
    val log4k = FakeLog4k()
    Any().run { a(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = KOTLIN_ANY),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testAssertWithAnnotation() {
    val log4k = FakeLog4k()
    val any = @LoggerConfig(
      enable = false,
      tag = ANY_TAG,
      owners = [ANY_OWNER]
    ) object : Any() {}
    any.run { a(ANY_MESSAGE, log4k = log4k) }
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(
          enable = false,
          tag = ANY_TAG,
          owners = arrayOf(ANY_OWNER)
        ),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }
}

private const val ANY_MESSAGE = "any-message"
private const val ANY_TAG = "any-tag"
private const val KOTLIN_ANY = "kotlin.Any"
private const val ANY_OWNER = "any-owner"
