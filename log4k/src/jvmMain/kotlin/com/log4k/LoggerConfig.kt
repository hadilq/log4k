package com.log4k

/**
 * An annotation to define the log config of a class.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class LoggerConfig(
  val enable: Boolean = true,
  val tag: String = "",
  val owners: Array<String> = [],
)

fun LoggerConfig?.map(clazz: String): Config = Config(
  enable = this?.enable ?: true,
  tag = this?.tag ?: clazz,
  owners = this?.owners ?: arrayOf()
)
