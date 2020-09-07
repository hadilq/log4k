package com.log4k.sample

import android.app.Application
import com.log4k.JVMAppender
import com.log4k.Level
import com.log4k.Log4k
import com.log4k.AndroidAppender
import java.io.File
import java.io.PrintWriter

class App : Application() {
  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) {
      Log4k.add(Level.Verbose, ".*", AndroidAppender())
      Log4k.add(Level.Verbose, "com\\.log4k\\.sample\\..+", JVMAppender())
      Log4k.add(
        Level.Verbose,
        ".*",
        JVMAppender(writer = PrintWriter(File(externalCacheDir, "debug-log.txt")))
      )
    } else {
      Log4k.add(
        Level.Assert,
        "com\\.log4k\\.sample\\..+",
        JVMAppender(writer = PrintWriter(File(filesDir, "log.txt")))
      )
    }
  }
}
