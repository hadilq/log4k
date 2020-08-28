package com.log4k.util

import com.log4k.JVMAppender
import java.io.PrintWriter
import java.io.StringWriter

class TestJVMAppender(
    private val out: StringWriter
) : JVMAppender(writer = PrintWriter(out), generateTimestamp = { "" })
