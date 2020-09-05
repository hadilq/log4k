package com.log4k

@Suppress("NO_REFLECTION_IN_CLASS_PATH")
actual inline fun <reified T> T.configuration(): Config =
  (T::class.annotations.find { it is LoggerConfig } as? LoggerConfig).map(tagName())
