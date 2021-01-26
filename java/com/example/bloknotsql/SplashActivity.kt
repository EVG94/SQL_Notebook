package com.example.bloknotsql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import com.google.android.material.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
     var handler:Handler = Handler()
    var potok:Runnable = Runnable {  }
    private val splash:Int = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        img_anim.animation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.bot_animation)
        tv_anim.animation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.top_animation)


        Handler().postDelayed({
                              val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
        }, 2900)
    }
}