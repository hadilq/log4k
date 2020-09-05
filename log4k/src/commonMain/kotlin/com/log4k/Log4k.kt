package com.log4k

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object Log4k : Log4kI by logger

private val logger = Log4kImpl()

interface Log4kI {

  /**
   * Adds an appender to log.
   *
   * Match Inheritance Rule:
   *   An appender with a defined [pattern] is enabled if its [pattern] matches the full class name of the log
   *   request.
   *
   * Basic Selection Rule:
   *   A log request of level p in a logger with [level] q, is enabled if p >= q.
   *
   * @param level in the basic selection rule above, this is the q param.
   * @param pattern is a Regex to match the full class names which we want to log.
   * @param appender is responsible for handling logs.
   */
  fun add(level: Level, pattern: Regex, appender: Appender): Log4kI

  /**
   * The same as above [add] method.

   * @param pattern matches to the full class names which we want to log.
   */
  fun add(level: Level, pattern: String, appender: Appender): Log4kI

  /**
   * Removes the [appender] to avoid logging anymore.
   */
  fun remove(appender: Appender)

  /**
   * Log [event]s based on "Basic Selection Rule" and "Match Inheritance Rule" below.
   *
   * Match Inheritance Rule:
   *   An appender with a defined pattern is enabled if its pattern matches the
   *   [Config.qualifiedName] (Full class name) of the log request.
   *
   * Basic Selection Rule:
   *   A log request of level [p] in a logger with level q, is enabled if [p] >= q.
   */
  fun log(p: Level, config: Config, event: Event)
}


internal class Log4kImpl : Log4kI {

  private val appenderSet = mutableSetOf<AppenderWrapper>()

  override fun add(level: Level, pattern: Regex, appender: Appender): Log4kI {
    appenderSet.add(AppenderWrapper(level, pattern, appender))
    return this
  }

  override fun add(level: Level, pattern: String, appender: Appender): Log4kI =
    add(level, Regex(pattern), appender)

  override fun remove(appender: Appender) {
    val iterator = appenderSet.iterator()
    while (iterator.hasNext()) {
      val w = iterator.next()
      if (w.appender === appender) {
        iterator.remove()
        break
      }
    }
  }

  override fun log(p: Level, config: Config, event: Event) {
    if (!config.enable) return
    appenderSet.forEach {
      val q = it.level
      if (p.level >= q.level && it.pattern.matches(config.qualifiedName)) {
        it.appender.logger(p, config, event)
      }
    }
  }

  private class AppenderWrapper(
    val level: Level,
    val pattern: Regex,
    val appender: Appender
  )
}
