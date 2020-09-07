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
@file:Suppress("NOTHING_TO_INLINE", "unused")

package com.log4k

import com.log4k.Level.*

/**
 * Send a [Verbose] log [message].
 */
inline fun <reified T> T.v(message: String, log4k: Log4kI = Log4k) =
  log4k.log(Verbose, configuration(), SimpleEvent(message))

/**
 * Send a [Debug] log [message].
 */
inline fun <reified T> T.d(message: String, log4k: Log4kI = Log4k) =
  log4k.log(Debug, configuration(), SimpleEvent(message))

/**
 * Send an [Info] log [message].
 */
inline fun <reified T> T.i(message: String, log4k: Log4kI = Log4k) =
  log4k.log(Info, configuration(), SimpleEvent(message))

/**
 * Send a [Warn] log [message].
 */
inline fun <reified T> T.w(message: String, log4k: Log4kI = Log4k) =
  log4k.log(Warn, configuration(), SimpleEvent(message))

/**
 * Send an [Error] log [message].
 */
inline fun <reified T> T.e(message: String, log4k: Log4kI = Log4k) =
  log4k.log(Error, configuration(), SimpleEvent(message))

/**
 * Send an [Assert] log [message].
 */
inline fun <reified T> T.a(message: String, log4k: Log4kI = Log4k) =
  log4k.log(Assert, configuration(), SimpleEvent(message))

/**
 * Send a [Verbose] log [String].
 * Example of use:
 * ```
 *    "This is the message".v()()
 * ```
 */
inline fun <reified T> String.v(log4k: Log4kI = Log4k): T.() -> Unit = {
  v(this@v, log4k)
}

/**
 * Send a [Debug] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".d()()
 * ```
 */
inline fun <reified T> String.d(log4k: Log4kI = Log4k): T.() -> Unit = {
  d(this@d, log4k)
}

/**
 * Send an [Info] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".i()()
 * ```
 */
inline fun <reified T> String.i(log4k: Log4kI = Log4k): T.() -> Unit = {
  i(this@i, log4k)
}

/**
 * Send a [Warn] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".w()()
 * ```
 */
inline fun <reified T> String.w(log4k: Log4kI = Log4k): T.() -> Unit = {
  w(this@w, log4k)
}

/**
 * Send an [Error] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".e()()
 * ```
 */
inline fun <reified T> String.e(log4k: Log4kI = Log4k): T.() -> Unit = {
  e(this@e, log4k)
}

/**
 * Send an [Assert] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".a()()
 * ```
 */
inline fun <reified T> String.a(log4k: Log4kI = Log4k): T.() -> Unit = {
  a(this@a, log4k)
}

/**
 * Send a [Verbose] log [message] and [throwable].
 */
inline fun <reified T> T.v(message: String, throwable: Throwable, log4k: Log4kI = Log4k) =
  log4k.log(Verbose, configuration(), SimpleThrowableEvent(message, throwable))

/**
 * Send a [Debug] log [message] and [throwable].
 */
inline fun <reified T> T.d(message: String, throwable: Throwable, log4k: Log4kI = Log4k) =
  log4k.log(Debug, configuration(), SimpleThrowableEvent(message, throwable))

/**
 * Send an [Info] log [message] and [throwable].
 */
inline fun <reified T> T.i(message: String, throwable: Throwable, log4k: Log4kI = Log4k) =
  log4k.log(Info, configuration(), SimpleThrowableEvent(message, throwable))

/**
 * Send a [Warn] log [message] and [throwable].
 */
inline fun <reified T> T.w(message: String, throwable: Throwable, log4k: Log4kI = Log4k) =
  log4k.log(Warn, configuration(), SimpleThrowableEvent(message, throwable))

/**
 * Send an [Error] log [message] and [throwable].
 */
inline fun <reified T> T.e(message: String, throwable: Throwable, log4k: Log4kI = Log4k) =
  log4k.log(Error, configuration(), SimpleThrowableEvent(message, throwable))

/**
 * Send an [Assert] log [message] and [throwable].
 */
inline fun <reified T> T.a(message: String, throwable: Throwable, log4k: Log4kI = Log4k) =
  log4k.log(Assert, configuration(), SimpleThrowableEvent(message, throwable))

/**
 * Send a [Verbose] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.v("This is the message")()
 * ```
 */
inline fun <reified T> Throwable.v(message: String, log4k: Log4kI = Log4k): T.() -> Unit = {
  v(message, this@v, log4k)
}

/**
 * Send a [Debug] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.d("This is the message")()
 * ```
 */
inline fun <reified T> Throwable.d(message: String, log4k: Log4kI = Log4k): T.() -> Unit = {
  d(message, this@d, log4k)
}

/**
 * Send an [Info] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.i("This is the message")()
 * ```
 */
inline fun <reified T> Throwable.i(message: String, log4k: Log4kI = Log4k): T.() -> Unit = {
  i(message, this@i, log4k)
}

/**
 * Send a [Warn] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.w("This is the message")()
 * ```
 */
inline fun <reified T> Throwable.w(message: String, log4k: Log4kI = Log4k): T.() -> Unit = {
  w(message, this@w, log4k)
}

/**
 * Send an [Error] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.e("This is the message")()
 * ```
 */
inline fun <reified T> Throwable.e(message: String, log4k: Log4kI = Log4k): T.() -> Unit = {
  e(message, this@e, log4k)
}

/**
 * Send an [Assert] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.a("This is the message")()
 * ```
 */
inline fun <reified T> Throwable.a(message: String, log4k: Log4kI = Log4k): T.() -> Unit = {
  a(message, this@a, log4k)
}

/**
 * Send a [Verbose] log [event].
 */
inline fun <reified T> T.v(event: Event, log4k: Log4kI = Log4k) =
  log4k.log(Verbose, configuration(), event)

/**
 * Send a [Debug] log [event].
 */
inline fun <reified T> T.d(event: Event, log4k: Log4kI = Log4k) =
  log4k.log(Debug, configuration(), event)

/**
 * Send an [Info] log [event].
 */
inline fun <reified T> T.i(event: Event, log4k: Log4kI = Log4k) =
  log4k.log(Info, configuration(), event)

/**
 * Send a [Warn] log [event].
 */
inline fun <reified T> T.w(event: Event, log4k: Log4kI = Log4k) =
  log4k.log(Warn, configuration(), event)

/**
 * Send an [Error] log [event].
 */
inline fun <reified T> T.e(event: Event, log4k: Log4kI = Log4k) =
  log4k.log(Error, configuration(), event)

/**
 * Send an [Assert] log [event].
 */
inline fun <reified T> T.a(event: Event, log4k: Log4kI = Log4k) =
  log4k.log(Assert, configuration(), event)

/**
 * Send a [Verbose] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().v()()
 * ```
 */
inline fun <reified T> Event.v(log4k: Log4kI = Log4k): T.() -> Unit = {
  v(this@v, log4k)
}


/**
 * Send a [Debug] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().d()()
 * ```
 */
inline fun <reified T> Event.d(log4k: Log4kI = Log4k): T.() -> Unit = {
  d(this@d, log4k)
}

/**
 * Send an [Info] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().i()()
 * ```
 */
inline fun <reified T> Event.i(log4k: Log4kI = Log4k): T.() -> Unit = {
  i(this@i, log4k)
}

/**
 * Send a [Warn] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().w()()
 * ```
 */
inline fun <reified T> Event.w(log4k: Log4kI = Log4k): T.() -> Unit = {
  w(this@w, log4k)
}

/**
 * Send an [Error] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().e()()
 * ```
 */
inline fun <reified T> Event.e(log4k: Log4kI = Log4k): T.() -> Unit = {
  e(this@e, log4k)
}

/**
 * Send an [Assert] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().a()()
 * ```
 */
inline fun <reified T> Event.a(log4k: Log4kI = Log4k): T.() -> Unit = {
  a(this@a, log4k)
}

/**
 * Log an assertion with a [message].
 */
inline fun <reified T> T.fail(message: String, log4k: Log4kI = Log4k) =
  fail(message, AssertionError(message), log4k)

/**
 * Log an assertion with a [message] and [throwable].
 */
inline fun <reified T> T.fail(message: String, throwable: Throwable, log4k: Log4kI = Log4k) =
  a(message, throwable, log4k)

/**
 * Log an assertion with a [message] if [condition] is false, else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeTrue(
    message: String,
    condition: Boolean,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
): LoggerBuilder? = LoggerBuilder.create(configuration(), log4k).assumeTrue(message, condition, callback)

/**
 * Log an assertion with a [message] if [condition] is true, else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeFalse(
    message: String,
    condition: Boolean,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration(), log4k).assumeFalse(message, condition, callback)

/**
 * Log an assertion with a [message] if [condition] is not empty, else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeEmpty(
    message: String,
    condition: String?,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration(), log4k).assumeEmpty(message, condition, callback)

/**
 * Log an assertion with a [message] if [collection] is not empty, else try the next assumption or run the [callback].
 */
inline fun <reified T, C> T.assumeEmpty(
    message: String,
    collection: Collection<C>?,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration(), log4k).assumeEmpty(message, collection, callback)

/**
 * Log an assertion with a [message] if [condition] is empty, else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeNotEmpty(
    message: String,
    condition: String?,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration(), log4k).assumeNotEmpty(message, condition, callback)

/**
 * Log an assertion with a [message] if [collection] is empty, else try the next assumption or run the [callback].
 */
inline fun <reified T, C> T.assumeNotEmpty(
    message: String,
    collection: Collection<C>?,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration(), log4k).assumeNotEmpty(message, collection, callback)

/**
 * Log an assertion with a [message] if [expected] value doesn't equal to [actual] value, else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeEquals(
    message: String,
    expected: Any?,
    actual: Any?,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration(), log4k).assumeEquals(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [expected] value equals to [actual] value, else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeNotEquals(
    message: String,
    expected: Any?,
    actual: Any?,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration(), log4k).assumeNotEquals(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [obj] is null, else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeNotNull(
    message: String,
    obj: Any?,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration(), log4k).assumeNotNull(message, obj, callback)

/**
 * Log an assertion with a [message] if [obj] is not null, else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeNull(
    message: String,
    obj: Any?,
    log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration(), log4k).assumeNull(message, obj, callback)

/**
 * Log an assertion with a [message] if [expected] is not the same as [actual], else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeSame(
    message: String,
    expected: Any?,
    actual: Any?, log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration(), log4k).assumeSame(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [expected] is the same as [actual], else try the next assumption or run the [callback].
 */
inline fun <reified T> T.assumeNotSame(
    message: String,
    expected: Any?,
    actual: Any?, log4k: Log4kI = Log4k,
    noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration(), log4k).assumeNotSame(message, expected, actual, callback)

inline fun <reified T> T.tagName(): String = T::class.qualifiedName ?: let {
  Log4k.log(
    Error,
    Config(qualifiedName = "Log4k"),
    SimpleThrowableEvent("Anonymous class", RuntimeException("Try to log on anonymous class!"))
  )
  "Log4k"
}

expect inline fun <reified T> T.configuration(): Config
