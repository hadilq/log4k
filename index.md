![Health Check](https://github.com/hadilq/log4k/workflows/Health%20Check/badge.svg?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.hadilq/log4k/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.hadilq/log4k)

Log4k
---
This is a simple library for logging in Kotlin. It's inspired by the famous Apache Log4j library. You can find the original repository that I pushed this library at https://github.com/sheypoor/log4k.

Usage
---
After installation, you just need to call a one letter function like the following.
```kotlin
     d("This is my log")
```
For more advance logging experience you can describe the assumptions of a method with this library as follows.
```kotlin
   fun exampleMethod(foo: Boolean, bar: Boolean, ..., baz: Any?) {
       assumeTrue("Message of AssertionError when this assumption is not satisfied", foo)
           ?.assumeFalse("The same as the above message", bar)
           ...
           ?.assumeNotNull("An other message", baz) {
               // If all the above assumptions get satisfied then this block will be running.
               // Else an Assertion log will be triggered on the proper Appenders.
           }
           // Add more assumptions for the next block
           ?.assumeEquals("A message", foo, bar) {
               // This block will be running if all the above assumptions are true.
           }
   }
```
In this way, a new developer in your team easily will understand the assumptions of the writer of the method. Also, if
each of the assumptions is not satisfied in the runtime, you can log the AssertionError to the Crashlytics or other
services for another review of the method in the future.

Installation
---
Since version 2.0.0 this library is a Kotlin Multiplatform library, so depend on what kind of module you use it in, you can use different artifact IDs. Download it in gradle for 

 * `Android` 
```groovy
implementation "com.github.hadilq:log4k-android:${log4kVersion}"
```
 * `JVM`
```groovy
implementation "com.github.hadilq:log4k-jvm:${log4kVersion}"
```
 * `Javascript`
```groovy
implementation "com.github.hadilq:log4k-js:${log4kVersion}"
```
 * `Common`
```groovy
implementation "com.github.hadilq:log4k-metadata:${log4kVersion}"
```
And finally in case of native module, for instance use
```groovy
implementation "com.github.hadilq:log4k-iosArm64:${log4kVersion}"
```

But be aware that here we annotated `object Log4k` with `kotlin.native.concurrent.ThreadLocal`, so you may need to apply the next step cofiguration on each thread that you want your logs not be ignored!

Snapshots of the development version are available in [Sonatype's snapshots repository](https://oss.sonatype.org/content/repositories/snapshots).

In the next step, we need to implement the visitors(in visitor design pattern sense), so for instance in Android apps, inside the `onCreate` method of your `Application` class setup it like this
```kotlin
if (BuildConfig.DEBUG) {
    Log4k.add(Level.Verbose, ".*", AndroidAppender())
    Log4k.add(Level.Verbose, "com\\.log4k\\.sample\\..+", JVMAppender())
    Log4k.add(Level.Verbose, ".*", JVMAppender(writer = PrintWriter(File(externalCacheDir, "debug-log.txt"))))
} else {
    Log4k.add(Level.Assert, "com\\.log4k\\.sample\\..+", JVMAppender(writer = PrintWriter(File(filesDir, "log.txt"))))
}
```
As you see, you can use any kind of appender to handle different kinds of logs. For instance, the `AndroidAppender`
appender log as an ordinary Android `Log`. Or the `JVMAppender(writer = PrintWriter(File(externalCacheDir, "debug-log.txt")))`
appender log into a file in external cache directory. And done!

More Usage
---

By the way, after installation you can use other features of this library. For instance, you can use `com.log4k.LoggerConfig` annotation in Android and JVM modules like this
```kotlin
@LoggerConfig(tag = "Here, if you need, can change the tag from the `qualifiedName` of `Example` class to any other `String`")
class Example {
  fun someMethod() {
    d("Reached here!") // Debug level

    try {
      ...
    } catch(error: Throwbale) {
      e("Message", error) // Error level
    }
    ...
    object : Comparable<Float> {
      override fun compareTo(other: Float): Int {
        // This is an anonymous class so using `d("Message")`
        // would not capture `LoggerConfig` config. 
        // Instead we can use
        "Message".i<Example>() // Info level
      }
    }
    ...
    SomeCustomeEventForTrackingInFirebase().(v())() // Verbose level
  }
}
```
where `LoggerConfig` defined as following.
```kotlin
annotation class LoggerConfig(
  val enable: Boolean = true,
  val tag: String = "",
  val owners: Array<String> = [],
)
```
so you can disable all logs of the `Example` class all together by setting `enable = false`. Or you can use this 
annotation to clarify who are the owners of this class.

As you find out in the above example there are different styles for logger methods, where I'm looking to find out which
one is working best for the users, so your feedback is welcome.


Contribution
---
Just create your branch from master branch, change it, write additional tests, satisfy all tests, create your pull
request, thank you, you're awesome.
