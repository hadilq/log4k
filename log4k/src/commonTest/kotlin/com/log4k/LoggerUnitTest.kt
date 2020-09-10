package com.log4k

import com.log4k.util.FakeLog4k
import com.log4k.util.LogData
import kotlin.test.Test

class LoggerUnitTest {

  private val tag = tagName(Any::class)

  @Test
  fun testVerbose() {
    val log4k = FakeLog4k()
    Any().v(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testDebug() {
    val log4k = FakeLog4k()
    Any().d(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testInfo() {
    val log4k = FakeLog4k()
    Any().i(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testWarn() {
    val log4k = FakeLog4k()
    Any().w(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testError() {
    val log4k = FakeLog4k()
    Any().e(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testAssert() {
    val log4k = FakeLog4k()
    Any().a(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testVerboseOnMessageFun() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.(v(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testDebugOnMessageFun() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.(d(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testInfoOnMessageFun() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.(i(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testWarnOnMessageFun() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.(w(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testErrorOnMessageFun() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.(e(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testAssertOnMessageFun() {
    val log4k = FakeLog4k()
    Any().run { ANY_MESSAGE.(a(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testVerboseOnMessage() {
    val log4k = FakeLog4k()
    ANY_MESSAGE.v<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testDebugOnMessage() {
    val log4k = FakeLog4k()
    ANY_MESSAGE.d<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testInfoOnMessage() {
    val log4k = FakeLog4k()
    ANY_MESSAGE.i<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testWarnOnMessage() {
    val log4k = FakeLog4k()
    ANY_MESSAGE.w<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testErrorOnMessage() {
    val log4k = FakeLog4k()
    ANY_MESSAGE.e<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testAssertOnMessage() {
    val log4k = FakeLog4k()
    ANY_MESSAGE.a<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = tag),
        SimpleEvent(ANY_MESSAGE)
      )
    )
  }

  @Test
  fun testVerboseWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().v(ANY_MESSAGE, throwable, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testDebugWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().d(ANY_MESSAGE, throwable, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testInfoWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().i(ANY_MESSAGE, throwable, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testWarnWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().w(ANY_MESSAGE, throwable, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testErrorWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().e(ANY_MESSAGE, throwable, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testAssertWithThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().a(ANY_MESSAGE, throwable, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testVerboseWithThrowableOnMessageFun() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { ANY_MESSAGE.(v(throwable, log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testDebugWithThrowableOnMessageFun() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { ANY_MESSAGE.(d(throwable, log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testInfoWithThrowableOnMessageFun() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { ANY_MESSAGE.(i(throwable, log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testWarnWithThrowableOnMessageFun() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { ANY_MESSAGE.(w(throwable, log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testErrorWithThrowableOnMessageFun() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { ANY_MESSAGE.(e(throwable, log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testAssertWithThrowableOnMessageFun() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    Any().run { ANY_MESSAGE.(a(throwable, log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }


  @Test
  fun testVerboseWithThrowableOnThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    throwable.v<Any>(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testDebugWithThrowableOnThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    throwable.d<Any>(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testInfoWithThrowableOnThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    throwable.i<Any>(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testWarnWithThrowableOnThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    throwable.w<Any>(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testErrorWithThrowableOnThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    throwable.e<Any>(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testAssertWithThrowableOnThrowable() {
    val log4k = FakeLog4k()
    val throwable = RuntimeException(ANY_MESSAGE)
    throwable.a<Any>(ANY_MESSAGE, log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = tag),
        SimpleThrowableEvent(ANY_MESSAGE, throwable)
      )
    )
  }

  @Test
  fun testVerboseOnEvent() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    event.v<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testDebugOnEvent() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    event.d<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testInfoOnEvent() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    event.i<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testWarnOnEvent() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    event.w<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testErrorOnEvent() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    event.e<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testAssertOnEvent() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    event.a<Any>(log4k = log4k)
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testVerboseOnEventFun() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    Any().run { event.(ve(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Verbose,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testDebugOnEventFun() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    Any().run { event.(de(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Debug,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testInfoOnEventFun() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    Any().run { event.(ie(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Info,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testWarnOnEventFun() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    Any().run { event.(we(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Warn,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testErrorOnEventFun() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    Any().run { event.(ee(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Error,
        Config(tag = tag),
        event
      )
    )
  }

  @Test
  fun testAssertOnEventFun() {
    val log4k = FakeLog4k()
    val event = SimpleThrowableEvent(ANY_MESSAGE, RuntimeException(ANY_MESSAGE))
    Any().run { event.(ae(log4k = log4k))() }
    log4k.assertValues(
      LogData(
        Level.Assert,
        Config(tag = tag),
        event
      )
    )
  }
}

private const val ANY_MESSAGE = "any-message"
