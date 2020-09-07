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

import com.log4k.util.TestAppender
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LoggerTest {

  private val qualifiedClass = tagName(this::class)
  private var appender: TestAppender? = null

  private fun setup() {
    appender?.let {
      Log4k.remove(it)
      appender = null
    }
    with(TestAppender()) {
      appender = this
      Log4k.add(Level.Verbose, ".*", this)
    }
  }

  @Test
  fun testVerbose() {
    setup()
    v("test")
    assertEquals(Level.Verbose, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleEvent("test"), appender?.box?.event)
  }

  @Test
  fun testDebug() {
    setup()
    d("test")
    assertEquals(Level.Debug, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleEvent("test"), appender?.box?.event)
  }

  @Test
  fun testInfo() {
    setup()
    i("test")
    assertEquals(Level.Info, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleEvent("test"), appender?.box?.event)

  }

  @Test
  fun testWarn() {
    setup()
    w("test")
    assertEquals(Level.Warn, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleEvent("test"), appender?.box?.event)
  }

  @Test
  fun testError() {
    setup()
    e("test")
    assertEquals(Level.Error, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleEvent("test"), appender?.box?.event)
  }

  @Test
  fun testAssert() {
    setup()
    a("test")
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleEvent("test"), appender?.box?.event)
  }

  @Test
  fun testVerboseThrowable() {
    setup()
    val throwable = RuntimeException("testing")
    v("test", throwable)
    assertEquals(Level.Verbose, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleThrowableEvent("test", throwable), appender?.box?.event)
  }

  @Test
  fun testDebugThrowable() {
    setup()
    val throwable = RuntimeException("testing")
    d("test", throwable)
    assertEquals(Level.Debug, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleThrowableEvent("test", throwable), appender?.box?.event)
  }

  @Test
  fun testInfoThrowable() {
    setup()
    val throwable = RuntimeException("testing")
    i("test", throwable)
    assertEquals(Level.Info, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleThrowableEvent("test", throwable), appender?.box?.event)
  }

  @Test
  fun testWarnThrowable() {
    setup()
    val throwable = RuntimeException("testing")
    w("test", throwable)
    assertEquals(Level.Warn, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleThrowableEvent("test", throwable), appender?.box?.event)
  }

  @Test
  fun testErrorThrowable() {
    setup()
    val throwable = RuntimeException("testing")
    e("test", throwable)
    assertEquals(Level.Error, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleThrowableEvent("test", throwable), appender?.box?.event)
  }

  @Test
  fun testAssertThrowable() {
    setup()
    val throwable = RuntimeException("testing")
    a("test", throwable)
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleThrowableEvent("test", throwable), appender?.box?.event)
  }

  @Test
  fun testFail() {
    setup()
    fail("test")
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testFailThrowable() {
    setup()
    val throwable = RuntimeException("testing")
    fail("test", throwable)
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    assertEquals(SimpleThrowableEvent("test", throwable), appender?.box?.event)
  }

  @Test
  fun testTrueAssumeTrue() {
    setup()
    assumeTrue("test", true)
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeTrue() {
    setup()
    assumeTrue("test", false)
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeFalse() {
    setup()
    assumeFalse("test", false)
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeFalse() {
    setup()
    assumeFalse("test", true)
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeEmpty() {
    setup()
    assumeEmpty("test", "")
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testTrueAssumeEmptyNull() {
    setup()
    assumeEmpty("test", null as String?)
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeEmpty() {
    setup()
    assumeEmpty("test", "sdfvv")
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeEmptyCollection() {
    setup()
    assumeEmpty("test", listOf<String>())
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testTrueAssumeEmptyNullCollection() {
    setup()
    assumeEmpty("test", null as List<String>?)
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeEmptyCollection() {
    setup()
    assumeEmpty("test", listOf("skfjnv"))
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeNotEmpty() {
    setup()
    assumeNotEmpty("test", "slfkdjnv")
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeNotEmptyNull() {
    setup()
    assumeNotEmpty("test", null as String?)
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testFalseAssumeNotEmpty() {
    setup()
    assumeNotEmpty("test", "")
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeNotEmptyCollection() {
    setup()
    assumeNotEmpty("test", listOf("slkdfjv"))
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeNotEmptyNullCollection() {
    setup()
    assumeNotEmpty("test", null as List<String>?)
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testFalseAssumeNotEmptyCollection() {
    setup()
    assumeNotEmpty("test", listOf<String>())
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeEquals() {
    setup()
    assumeEquals("test", "a", "a")
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeEquals() {
    setup()
    assumeEquals("test", "a", "b")
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeNotEquals() {
    setup()
    assumeNotEquals("test", "a", "b")
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeNotEquals() {
    setup()
    assumeNotEquals("test", "a", "a")
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeNotNull() {
    setup()
    assumeNotNull("test", "")
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeNotNull() {
    setup()
    assumeNotNull("test", null)
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeNull() {
    setup()
    assumeNull("test", null)
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeNull() {
    setup()
    assumeNull("test", "")
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeSame() {
    setup()
    val a = Any()
    assumeSame("test", a, a)
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeSame() {
    setup()
    assumeSame("test", Any(), Any())
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testTrueAssumeNotSame() {
    setup()
    assumeNotSame("test", Any(), Any())
    assertFalse(appender?.box?.logged ?: true)
  }

  @Test
  fun testFalseAssumeNotSame() {
    setup()
    val a = Any()
    assumeNotSame("test", a, a)
    assertEquals(Level.Assert, appender?.box?.level)
    assertEquals(qualifiedClass, appender?.box?.clazz)
    val event = appender?.box?.event
    assertTrue(event is SimpleThrowableEvent)
    assertTrue(event.message == "test")
    assertTrue(event.throwable is AssertionError)
    assertTrue(event.throwable.message == "test")
  }

  @Test
  fun testMultiAssert() {
    val message = "Assumptions are correct"
    var out = ""
    assumeTrue("test1", true)
      ?.assumeTrue("test2", true)
      ?.assumeFalse("test3", false) {
        out = message
      }
    assertEquals(message, out)
  }
}
