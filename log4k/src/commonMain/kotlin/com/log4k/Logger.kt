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
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Verbose, configuration, SimpleEvent(message))

/**
 * Send a [Debug] log [message].
 */
inline fun <reified T : Any> T.d(
  message: String,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Debug, configuration, SimpleEvent(message))

/**
 * Send an [Info] log [message].
 */
inline fun <reified T : Any> T.i(
  message: String,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Info, configuration, SimpleEvent(message))

/**
 * Send a [Warn] log [message].
 */
inline fun <reified T : Any> T.w(
  message: String,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Warn, configuration, SimpleEvent(message))

/**
 * Send an [Error] log [message].
 */
inline fun <reified T : Any> T.e(
  message: String,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Error, configuration, SimpleEvent(message))

/**
 * Send an [Assert] log [message].
 */
inline fun <reified T : Any> T.a(
  message: String,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Assert, configuration, SimpleEvent(message))

/**
 * Send a [Verbose] log [String].
 * Example of use:
 * ```
 *    "This is the message".v()
 * ```
 */
inline fun <reified T : Any> String.v(
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Verbose, configuration, SimpleEvent(this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Debug, configuration, SimpleEvent(this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Info, configuration, SimpleEvent(this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Warn, configuration, SimpleEvent(this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Error, configuration, SimpleEvent(this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Assert, configuration, SimpleEvent(this))
}

/**
 * Send a [Verbose] log [message] and [throwable].
 */
inline fun <reified T : Any> T.v(
  message: String, throwable: Throwable,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Verbose, configuration, SimpleThrowableEvent(message, throwable))

/**
 * Send a [Debug] log [message] and [throwable].
 */
inline fun <reified T : Any> T.d(
  message: String, throwable: Throwable,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Debug, configuration, SimpleThrowableEvent(message, throwable))

/**
 * Send an [Info] log [message] and [throwable].
 */
inline fun <reified T : Any> T.i(
  message: String, throwable: Throwable,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Info, configuration, SimpleThrowableEvent(message, throwable))

/**
 * Send a [Warn] log [message] and [throwable].
 */
inline fun <reified T : Any> T.w(
  message: String, throwable: Throwable,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Warn, configuration, SimpleThrowableEvent(message, throwable))

/**
 * Send an [Error] log [message] and [throwable].
 */
inline fun <reified T : Any> T.e(
  message: String, throwable: Throwable,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Error, configuration, SimpleThrowableEvent(message, throwable))

/**
 * Send an [Assert] log [message] and [throwable].
 */
inline fun <reified T : Any> T.a(
  message: String, throwable: Throwable,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Assert, configuration, SimpleThrowableEvent(message, throwable))

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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Verbose, configuration, SimpleThrowableEvent(message, this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Debug, configuration, SimpleThrowableEvent(message, this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Info, configuration, SimpleThrowableEvent(message, this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Warn, configuration, SimpleThrowableEvent(message, this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Error, configuration, SimpleThrowableEvent(message, this))
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Assert, configuration, SimpleThrowableEvent(message, this))
}

/**
 * Send a [Verbose] log [event].
 */
inline fun <reified T : Any> T.v(
  event: Event,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Verbose, configuration, event)

/**
 * Send a [Debug] log [event].
 */
inline fun <reified T : Any> T.d(
  event: Event,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Debug, configuration, event)

/**
 * Send an [Info] log [event].
 */
inline fun <reified T : Any> T.i(
  event: Event,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Info, configuration, event)

/**
 * Send a [Warn] log [event].
 */
inline fun <reified T : Any> T.w(
  event: Event,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Warn, configuration, event)

/**
 * Send an [Error] log [event].
 */
inline fun <reified T : Any> T.e(
  event: Event,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Error, configuration, event)

/**
 * Send an [Assert] log [event].
 */
inline fun <reified T : Any> T.a(
  event: Event,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  log4k.log(Assert, configuration, event)

/**
 * Send a [Verbose] log [Event].
 *
 * Example of use:
 * ```
 *    EventImpl().v()
 * ```
 */
inline fun <reified T : Any> Event.v(
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Verbose, configuration, this)
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Debug, configuration, this)
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Info, configuration, this)
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Warn, configuration, this)
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Error, configuration, this)
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
  configuration: Config = configuration(T::class),
  log4k: Log4kI = Log4k
) {
  log4k.log(Assert, configuration, this)
}

/**
 * Log an assertion with a [message].
 */
inline fun <reified T : Any> T.fail(
  message: String,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  fail(message, AssertionError(message), configuration, log4k)

/**
 * Log an assertion with a [message] and [throwable].
 */
inline fun <reified T : Any> T.fail(
  message: String, throwable: Throwable,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k
) =
  a(message, throwable, configuration, log4k)

/**
 * Log an assertion with a [message] if [condition] is false, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeTrue(
  message: String,
  condition: Boolean,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
): LoggerBuilder? =
  LoggerBuilder.create(configuration, log4k).assumeTrue(message, condition, callback)

/**
 * Log an assertion with a [message] if [condition] is true, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeFalse(
  message: String,
  condition: Boolean,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration, log4k).assumeFalse(message, condition, callback)

/**
 * Log an assertion with a [message] if [condition] is not empty, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeEmpty(
  message: String,
  condition: String?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration, log4k).assumeEmpty(message, condition, callback)

/**
 * Log an assertion with a [message] if [collection] is not empty, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any, C> T.assumeEmpty(
  message: String,
  collection: Collection<C>?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration, log4k).assumeEmpty(message, collection, callback)

/**
 * Log an assertion with a [message] if [condition] is empty, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNotEmpty(
  message: String,
  condition: String?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration, log4k).assumeNotEmpty(message, condition, callback)

/**
 * Log an assertion with a [message] if [collection] is empty, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any, C> T.assumeNotEmpty(
  message: String,
  collection: Collection<C>?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration, log4k).assumeNotEmpty(message, collection, callback)

/**
 * Log an assertion with a [message] if [expected] value doesn't equal to [actual] value, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeEquals(
  message: String,
  expected: Any?,
  actual: Any?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration, log4k).assumeEquals(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [expected] value equals to [actual] value, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNotEquals(
  message: String,
  expected: Any?,
  actual: Any?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration, log4k).assumeNotEquals(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [obj] is null, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNotNull(
  message: String,
  obj: Any?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration, log4k).assumeNotNull(message, obj, callback)

/**
 * Log an assertion with a [message] if [obj] is not null, else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNull(
  message: String,
  obj: Any?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) =
  LoggerBuilder.create(configuration, log4k).assumeNull(message, obj, callback)

/**
 * Log an assertion with a [message] if [expected] is not the same as [actual], else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeSame(
  message: String,
  expected: Any?,
  actual: Any?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration, log4k).assumeSame(message, expected, actual, callback)

/**
 * Log an assertion with a [message] if [expected] is the same as [actual], else try the next assumption or run the [callback].
 */
inline fun <reified T : Any> T.assumeNotSame(
  message: String,
  expected: Any?,
  actual: Any?,
  configuration: Config = configuration(),
  log4k: Log4kI = Log4k,
  noinline callback: (() -> Unit)? = null
) = LoggerBuilder.create(configuration, log4k).assumeNotSame(message, expected, actual, callback)

inline fun <reified T : Any> T.configuration(): Config = configuration(T::class)

expect fun <T : Any> tagName(clazz: KClass<T>): String

expect fun <T : Any> configuration(clazz: KClass<T>): Config
