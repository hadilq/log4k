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
import kotlin.reflect.KClass

/**
 * Send a [Verbose] log [message].
 */
inline fun <reified T : Any> T.v(
  message: String,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Verbose, config, SimpleEvent(message))

/**
 * Send a [Debug] log [message].
 */
inline fun <reified T : Any> T.d(
  message: String,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Debug, config, SimpleEvent(message))

/**
 * Send an [Info] log [message].
 */
inline fun <reified T : Any> T.i(
  message: String,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Info, config, SimpleEvent(message))

/**
 * Send a [Warn] log [message].
 */
inline fun <reified T : Any> T.w(
  message: String,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Warn, config, SimpleEvent(message))

/**
 * Send an [Error] log [message].
 */
inline fun <reified T : Any> T.e(
  message: String,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Error, config, SimpleEvent(message))

/**
 * Send an [Assert] log [message].
 */
inline fun <reified T : Any> T.a(
  message: String,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Assert, config, SimpleEvent(message))

/**
 * Send a [Verbose] log [String].
 * Example of use:
 * ```
 *    "This is the message".v()
 * ```
 */
inline fun <reified T : Any> String.v(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Verbose, config, SimpleEvent(this))
}

/**
 * Send a [Debug] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".d()
 * ```
 */
inline fun <reified T : Any> String.d(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Debug, config, SimpleEvent(this))
}

/**
 * Send an [Info] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".i()
 * ```
 */
inline fun <reified T : Any> String.i(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Info, config, SimpleEvent(this))
}

/**
 * Send a [Warn] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".w()
 * ```
 */
inline fun <reified T : Any> String.w(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Warn, config, SimpleEvent(this))
}

/**
 * Send an [Error] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".e()
 * ```
 */
inline fun <reified T : Any> String.e(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Error, config, SimpleEvent(this))
}

/**
 * Send an [Assert] log [String].
 *
 * Example of use:
 * ```
 *    "This is the message".a()
 * ```
 */
inline fun <reified T : Any> String.a(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Assert, config, SimpleEvent(this))
}

/**
 * Send a [Verbose] log [message] and [throwable].
 */
inline fun <reified T : Any> T.v(
  message: String, throwable: Throwable,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Verbose, config, SimpleThrowableEvent(message, throwable))

/**
 * Send a [Debug] log [message] and [throwable].
 */
inline fun <reified T : Any> T.d(
  message: String, throwable: Throwable,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Debug, config, SimpleThrowableEvent(message, throwable))

/**
 * Send an [Info] log [message] and [throwable].
 */
inline fun <reified T : Any> T.i(
  message: String, throwable: Throwable,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Info, config, SimpleThrowableEvent(message, throwable))

/**
 * Send a [Warn] log [message] and [throwable].
 */
inline fun <reified T : Any> T.w(
  message: String, throwable: Throwable,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Warn, config, SimpleThrowableEvent(message, throwable))

/**
 * Send an [Error] log [message] and [throwable].
 */
inline fun <reified T : Any> T.e(
  message: String, throwable: Throwable,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Error, config, SimpleThrowableEvent(message, throwable))

/**
 * Send an [Assert] log [message] and [throwable].
 */
inline fun <reified T : Any> T.a(
  message: String, throwable: Throwable,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Assert, config, SimpleThrowableEvent(message, throwable))

/**
 * Send a [Verbose] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.v("This is the message")
 * ```
 */
inline fun <reified T : Any> Throwable.v(
  message: String,
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Verbose, config, SimpleThrowableEvent(message, this))
}

/**
 * Send a [Debug] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.d("This is the message")
 * ```
 */
inline fun <reified T : Any> Throwable.d(
  message: String,
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Debug, config, SimpleThrowableEvent(message, this))
}

/**
 * Send an [Info] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.i("This is the message")
 * ```
 */
inline fun <reified T : Any> Throwable.i(
  message: String,
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Info, config, SimpleThrowableEvent(message, this))
}

/**
 * Send a [Warn] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.w("This is the message")
 * ```
 */
inline fun <reified T : Any> Throwable.w(
  message: String,
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Warn, config, SimpleThrowableEvent(message, this))
}

/**
 * Send an [Error] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.e("This is the message")
 * ```
 */
inline fun <reified T : Any> Throwable.e(
  message: String,
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Error, config, SimpleThrowableEvent(message, this))
}

/**
 * Send an [Assert] log [message] and [Throwable].
 *
 * Example of use:
 * ```
 *    error.a("This is the message")
 * ```
 */
inline fun <reified T : Any> Throwable.a(
  message: String,
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Assert, config, SimpleThrowableEvent(message, this))
}

/**
 * Send a [Verbose] log [event].
 */
inline fun <reified T : Any> T.v(
  event: Event,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Verbose, config, event)

/**
 * Send a [Debug] log [event].
 */
inline fun <reified T : Any> T.d(
  event: Event,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Debug, config, event)

/**
 * Send an [Info] log [event].
 */
inline fun <reified T : Any> T.i(
  event: Event,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Info, config, event)

/**
 * Send a [Warn] log [event].
 */
inline fun <reified T : Any> T.w(
  event: Event,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Warn, config, event)

/**
 * Send an [Error] log [event].
 */
inline fun <reified T : Any> T.e(
  event: Event,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Error, config, event)

/**
 * Send an [Assert] log [event].
 */
inline fun <reified T : Any> T.a(
  event: Event,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Assert, config, event)

/**
 * Send a [Verbose] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().v()
 * ```
 */
inline fun <reified T : Any> Event.v(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Verbose, config, this)
}


/**
 * Send a [Debug] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().d()
 * ```
 */
inline fun <reified T : Any> Event.d(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Debug, config, this)
}

/**
 * Send an [Info] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().i()
 * ```
 */
inline fun <reified T : Any> Event.i(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Info, config, this)
}

/**
 * Send a [Warn] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().w()
 * ```
 */
inline fun <reified T : Any> Event.w(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Warn, config, this)
}

/**
 * Send an [Error] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().e()
 * ```
 */
inline fun <reified T : Any> Event.e(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Error, config, this)
}

/**
 * Send an [Assert] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().a()
 * ```
 */
inline fun <reified T : Any> Event.a(
  config: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Assert, config, this)
}

/**
 * Log an assertion with a [message].
 */
inline fun <reified T : Any> T.fail(
  message: String,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  fail(message, AssertionError(message), config, log4k)

/**
 * Log an assertion with a [message] and [throwable].
 */
inline fun <reified T : Any> T.fail(
  message: String, throwable: Throwable,
  config: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  a(message, throwable, config, log4k)

/**
 * Log an assertion with a [message] if [condition] is false, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeTrue(
  message: String,
  condition: Boolean,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
): LoggerBuilder? =
  LoggerBuilder.create(config, log4k).assumeTrue(message, condition, callback)

/**
 * Log an assertion with a [message] if [condition] is true, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeFalse(
  message: String,
  condition: Boolean,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(config, log4k).assumeFalse(message, condition, callback)

/**
 * Log an assertion with a [message] if [condition] is not empty, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeEmpty(
  message: String,
  condition: String?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(config, log4k).assumeEmpty(message, condition, callback)

/**
 * Log an assertion with a [message] if [collection] is not empty, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any, C> T.assumeEmpty(
  message: String,
  collection: Collection<C>?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(config, log4k).assumeEmpty(message, collection, callback)

/**
 * Log an assertion with a [message] if [condition] is empty, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNotEmpty(
  message: String,
  condition: String?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(config, log4k).assumeNotEmpty(message, condition, callback)

/**
 * Log an assertion with a [message] if [collection] is empty, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any, C> T.assumeNotEmpty(
  message: String,
  collection: Collection<C>?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(config, log4k).assumeNotEmpty(message, collection, callback)

/**
 * Log an assertion with a [message] if [expected] value doesn't equal to [actual] value, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeEquals(
  message: String,
  expected: Any?,
  actual: Any?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(config, log4k).assumeEquals(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [expected] value equals to [actual] value, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNotEquals(
  message: String,
  expected: Any?,
  actual: Any?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(config, log4k).assumeNotEquals(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [obj] is null, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNotNull(
  message: String,
  obj: Any?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(config, log4k).assumeNotNull(message, obj, callback)

/**
 * Log an assertion with a [message] if [obj] is not null, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNull(
  message: String,
  obj: Any?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(config, log4k).assumeNull(message, obj, callback)

/**
 * Log an assertion with a [message] if [expected] is not the same as [actual], else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeSame(
  message: String,
  expected: Any?,
  actual: Any?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(config, log4k).assumeSame(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [expected] is the same as [actual], else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNotSame(
  message: String,
  expected: Any?,
  actual: Any?,
  config: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(config, log4k).assumeNotSame(message, expected, actual, callback)

inline fun <reified T : Any> T.configuration(): Config = configuration(T::class)

expect fun <T : Any> tagName(clazz: KClass<T>): String

expect fun <T : Any> configuration(clazz: KClass<T>): Config
