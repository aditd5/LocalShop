package com.aditd5.localshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditd5.localshop.databinding.ActivityProductDetailBinding

private lateinit var binding: ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}