package com.aditd5.localshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.aditd5.localshop.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    private val  SPLASH_TIME_OUT = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler().postDelayed({
            checkLoginStatus()
        },SPLASH_TIME_OUT)
    }

    private fun checkLoginStatus() {
        val sharedPreferences = getSharedPreferences("login_pref", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("is_logged_in",false)

        val intent = if (isLoggedIn) {
            Intent(this,HomeActivity::class.java)

        } else {
            Intent(this,SignInActivity::class.java)
        }
        startActivity(intent)
        finish()
    }
}