package com.log4k

import kotlin.reflect.KClass

actual fun <T : Any> configuration(clazz: KClass<T>): Config = Config(
  enable = true,
  qualifiedName = tagName(clazz),
  owners = arrayOf()
)
