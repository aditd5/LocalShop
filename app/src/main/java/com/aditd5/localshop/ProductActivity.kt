package com.aditd5.localshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.aditd5.localshop.adapter.ProdukAdapter
import com.aditd5.localshop.api.APIConfig
import com.aditd5.localshop.databinding.ActivityProductBinding
import com.aditd5.localshop.model.ProdukResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding
    private lateinit var produkAdapter: ProdukAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        produkAdapter = ProdukAdapter(arrayListOf())
        binding.rvKategori.adapter = produkAdapter
        retrieveData()
    }

    private fun retrieveData() {
        APIConfig.apiInstance.dataProduk().enqueue(object : Callback<ProdukResponse> {
            override fun onResponse(
                call: Call<ProdukResponse>,
                response: Response<ProdukResponse>
            ) {
                if (response.isSuccessful) {
                    val produkResponse = response.body()
                    val produkData = produkResponse?.data
                    Log.e("produkData", produkData.toString())
                    val produkAdapter = produkData?.let { ProdukAdapter(it) }
                    binding.rvKategori.apply {
//                        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        layoutManager = GridLayoutManager(context, 2)
                        adapter = produkAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ProdukResponse>, t: Throwable) {
                Log.e("ProductActivity", t.toString())
            }
        })
    }
}