package com.log4k.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.log4k.android.d

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        d("onCreate is called")
    }
}
