package com.log4k.util

import com.log4k.Appender
import com.log4k.Event
import com.log4k.Level
import io.mockk.mockk

class TestAppender(
  val box: Box = Box(),
) : Appender(
  logger = { level, clazz, event ->
    box.level = level
    box.clazz = clazz
    box.event = event
    box.logged = true
  }
)

data class Box(
  var level: Level = mockk(),
  var clazz: String = "",
  var event: Event = mockk(),
  var logged: Boolean = false,
)
