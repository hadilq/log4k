package com.log4k.util

import com.log4k.Appender
import com.log4k.Event
import com.log4k.Level

class TestAppender(
  val box: Box = Box(),
) : Appender(
  logger = { level, config, event ->
    box.level = level
    box.clazz = config.qualifiedName
    box.event = event
    box.logged = true
  }
)

data class Box(
  var level: Level? = null,
  var clazz: String? = null,
  var event: Event? = null,
  var logged: Boolean = false,
)
