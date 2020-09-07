package com.log4k

import kotlin.reflect.KClass

@Suppress("NO_REFLECTION_IN_CLASS_PATH")
actual fun <T:Any> configuration(clazz: KClass<T>): Config =
  (clazz.annotations.find { it is LoggerConfig } as? LoggerConfig).map(tagName(clazz))
