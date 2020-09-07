package com.log4k

import kotlin.reflect.KClass

actual fun <T : Any> tagName(clazz: KClass<T>): String = clazz.qualifiedName ?: run {
  Log4k.log(
    Level.Error,
    Config(qualifiedName = "Log4k"),
    SimpleThrowableEvent("Anonymous class", RuntimeException("Try to log on anonymous class!"))
  )
  "Log4k"
}

@Suppress("NO_REFLECTION_IN_CLASS_PATH")
actual fun <T:Any> configuration(clazz: KClass<T>): Config =
  (clazz.annotations.find { it is LoggerConfig } as? LoggerConfig).map(tagName(clazz))

