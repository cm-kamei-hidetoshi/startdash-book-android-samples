package com.cmtaro.app.glideexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = DrawableCrossFadeFactory.Builder(1000)
                .setCrossFadeEnabled(true)
                .build()

        GlideApp.with(this)
                .load("https://user-images.githubusercontent.com/43799962/74223081-4667d900-4cf9-11ea-94e0-d2db72213dc7.jpg")
                .error(ColorDrawable(Color.RED))
                .placeholder(ColorDrawable(Color.GRAY)) // この行を追加
                .transform(RoundedCorners(32))  // この行を追加
                .transition(withCrossFade(factory)) // この行を追加
                .into(findViewById(R.id.image_view))
    }
}
