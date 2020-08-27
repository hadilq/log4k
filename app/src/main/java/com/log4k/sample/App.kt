package com.log4k.sample

import android.app.Application
import com.log4k.DefaultAppender
import com.log4k.Level
import com.log4k.Log4kTmp
import com.log4k.android.AndroidAppender
import java.io.File
import java.io.PrintWriter

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Log4kTmp.add(Level.Verbose, ".*", AndroidAppender())
            Log4kTmp.add(Level.Verbose, "com\\.log4k\\.sample\\..+", DefaultAppender())
            Log4kTmp.add(Level.Verbose, ".*", DefaultAppender(writer = PrintWriter(File(externalCacheDir, "debug-log.txt"))))
        } else {
            Log4kTmp.add(Level.Assert, "com\\.log4k\\.sample\\..+", DefaultAppender(writer = PrintWriter(File(filesDir, "log.txt"))))
        }
    }
}
