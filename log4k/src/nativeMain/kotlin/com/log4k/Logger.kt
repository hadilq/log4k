package com.log4k

import kotlin.reflect.KClass

actual fun <T : Any> tagName(clazz: KClass<T>): String = clazz.qualifiedName ?: run {
  Log4k.log(
    Level.Error,
    Config(tag = "Log4k"),
    SimpleThrowableEvent("Anonymous class", RuntimeException("Try to log on anonymous class!"))
  )
  "Log4k"
}

actual fun <T : Any> configuration(clazz: KClass<T>): Config = Config(
  enable = true,
  tag = tagName(clazz),
  owners = arrayOf()
)
