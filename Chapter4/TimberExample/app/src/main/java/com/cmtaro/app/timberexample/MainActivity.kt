package com.cmtaro.app.timberexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResumeが実行された")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPauseが実行された")
    }
}
