package com.log4k

import com.log4k.util.FakeLog4k
import com.log4k.util.LogData
import kotlin.test.Test

class LoggerUnitTest {

  @Test
  fun testVerbose() {
    val log4k = FakeLog4k()
    Any().v(ANY_MESSAGE, log4k)
    log4k.assertValues(LogData(Level.Verbose, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testDebug() {
    val log4k = FakeLog4k()
    Any().d(ANY_MESSAGE, log4k)
    log4k.assertValues(LogData(Level.Debug, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testInfo() {
    val log4k = FakeLog4k()
    Any().i(ANY_MESSAGE, log4k)
    log4k.assertValues(LogData(Level.Info, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testWarn() {
    val log4k = FakeLog4k()
    Any().w(ANY_MESSAGE, log4k)
    log4k.assertValues(LogData(Level.Warn, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testError() {
    val log4k = FakeLog4k()
    Any().e(ANY_MESSAGE, log4k)
    log4k.assertValues(LogData(Level.Error, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testAssert() {
    val log4k = FakeLog4k()
    Any().a(ANY_MESSAGE, log4k)
    log4k.assertValues(LogData(Level.Assert, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testVerboseOnMessage() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.v<Any>(log4k)() }
    log4k.assertValues(LogData(Level.Verbose, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testDebugOnMessage() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.d<Any>(log4k)() }
    log4k.assertValues(LogData(Level.Debug, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testInfoOnMessage() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.i<Any>(log4k)() }
    log4k.assertValues(LogData(Level.Info, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testWarnOnMessage() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.w<Any>(log4k)() }
    log4k.assertValues(LogData(Level.Warn, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testErrorOnMessage() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.e<Any>(log4k)() }
    log4k.assertValues(LogData(Level.Error, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testAssertOnMessage() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.a<Any>(log4k)() }
    log4k.assertValues(LogData(Level.Assert, ANY_CLASS, SimpleEvent(ANY_MESSAGE)))
  }

  @Test
  fun testVerboseWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().v(ANY_MESSAGE, throwable, log4k)
    log4k.assertValues(
      LogData(
        Level.Verbose,
        ANY_CLASS,
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testDebugWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().d(ANY_MESSAGE, throwable, log4k)
    log4k.assertValues(
      LogData(
        Level.Debug,
        ANY_CLASS,
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testInfoWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().i(ANY_MESSAGE, throwable, log4k)
    log4k.assertValues(LogData(Level.Info, ANY_CLASS, SimpleThrowableEvent(ANY_MESSAGE, throwable)))
  }

  @Test
  fun testWarnWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().w(ANY_MESSAGE, throwable, log4k)
    log4k.assertValues(LogData(Level.Warn, ANY_CLASS, SimpleThrowableEvent(ANY_MESSAGE, throwable)))
  }

  @Test
  fun testErrorWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().e(ANY_MESSAGE, throwable, log4k)
    log4k.assertValues(
      LogData(
        Level.Error,
        ANY_CLASS,
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testAssertWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().a(ANY_MESSAGE, throwable, log4k)
    log4k.assertValues(
      LogData(
        Level.Assert,
        ANY_CLASS,
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testVerboseWithThrowableOnMessage() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { throwable.v<Any>(ANY_MESSAGE, log4k)() }
    log4k.assertValues(
      LogData(
        Level.Verbose,
        ANY_CLASS,
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testDebugWithThrowableOnMessage() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { throwable.d<Any>(ANY_MESSAGE, log4k)() }
    log4k.assertValues(
      LogData(
        Level.Debug,
        ANY_CLASS,
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testInfoWithThrowableOnMessage() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { throwable.i<Any>(ANY_MESSAGE, log4k)() }
    log4k.assertValues(LogData(Level.Info, ANY_CLASS, SimpleThrowableEvent(ANY_MESSAGE, throwable)))
  }

  @Test
  fun testWarnWithThrowableOnMessage() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { throwable.w<Any>(ANY_MESSAGE, log4k)() }
    log4k.assertValues(LogData(Level.Warn, ANY_CLASS, SimpleThrowableEvent(ANY_MESSAGE, throwable)))
  }

  @Test
  fun testErrorWithThrowableOnMessage() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { throwable.e<Any>(ANY_MESSAGE, log4k)() }
    log4k.assertValues(
      LogData(
        Level.Error,
        ANY_CLASS,
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testAssertWithThrowableOnMessage() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { throwable.a<Any>(ANY_MESSAGE, log4k)() }
    log4k.assertValues(
      LogData(
        Level.Assert,
        ANY_CLASS,
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }
}

private const val ANY_MESSAGE = "any-message"
private const val ANY_CLASS = "kotlin.Any"
