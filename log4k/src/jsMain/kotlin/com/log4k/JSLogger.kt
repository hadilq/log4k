package com.log4k

import kotlin.reflect.KClass

actual fun <T : Any> tagName(clazz: KClass<T>): String = clazz.toString()

@Suppress("NO_REFLECTION_IN_CLASS_PATH")
actual fun <T : Any> configuration(clazz: KClass<T>): Config = Config(
  enable = true,
  qualifiedName = tagName(clazz),
  owners = arrayOf()
)
