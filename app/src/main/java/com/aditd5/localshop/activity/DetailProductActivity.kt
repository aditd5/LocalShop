package com.aditd5.localshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditd5.localshop.databinding.ActivityProductDetailBinding

private lateinit var binding: ActivityProductDetailBinding

class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}