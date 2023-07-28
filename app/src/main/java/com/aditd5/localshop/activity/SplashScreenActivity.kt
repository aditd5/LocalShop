package com.aditd5.localshop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.aditd5.localshop.activity.home.HomeActivity
import com.aditd5.localshop.databinding.ActivitySplashScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var auth: FirebaseAuth

    private val  SPLASH_TIME_OUT = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth

        Handler().postDelayed({
            val currentUser = auth.currentUser
            if (currentUser != null) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finishAffinity()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }
        },SPLASH_TIME_OUT)
    }
}