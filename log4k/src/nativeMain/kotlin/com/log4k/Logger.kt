package com.log4k

actual inline fun <reified T> T.configuration(): Config = Config(
  enable = true,
  qualifiedName = tagName(),
  owners = arrayOf()
)
