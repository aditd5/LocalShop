package com.aditd5.localshop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditd5.localshop.databinding.ActivityItemCategoryBinding

class ItemCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityItemCategoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, DetailCategoryActivity::class.java)
            startActivity(intent)
        }
    }
}