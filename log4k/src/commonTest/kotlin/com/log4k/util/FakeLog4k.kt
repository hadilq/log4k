package com.log4k.util

import com.log4k.*
import kotlin.test.assertEquals

class FakeLog4k : Log4kI {

  private val values = mutableListOf<LogData>()

  override fun add(level: Level, pattern: Regex, appender: Appender): Log4kI = this

  override fun add(level: Level, pattern: String, appender: Appender): Log4kI = this

  override fun remove(appender: Appender) = Unit

  override fun log(p: Level, config: Config, event: Event) {
    values.add(LogData(p, config, event))
  }

  fun assertValues(vararg v: LogData) {
    assertEquals(v.toList(), values)
  }
}

data class LogData(
  val p: Level,
  val config: Config,
  val event: Event
)
