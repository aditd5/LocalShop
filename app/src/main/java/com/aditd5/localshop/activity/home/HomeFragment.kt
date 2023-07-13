package com.aditd5.localshop.activity.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
//import com.aditd5.localshop.data.HomeCategory
import com.aditd5.localshop.adapter.ProdukAdapter
import com.aditd5.localshop.api.APIConfig
import com.aditd5.localshop.api.APIService
//import com.aditd5.localshop.adapter.HomeCategoryAdapter
//import com.aditd5.localshop.data.categoryList
import com.aditd5.localshop.databinding.FragmentHomeBinding
import com.aditd5.localshop.model.ProdukData
import com.aditd5.localshop.model.ProdukResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

//    private val apiRetrofit by lazy { APIRetrofit().endpoint }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var produkAdapter: ProdukAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.rvKategori.layoutManager = LinearLayoutManager(context)
//        binding.rvKategori.setHasFixedSize(true)
//        binding.rvKategori.adapter = produkAdapter
        produkAdapter = ProdukAdapter(arrayListOf())
        binding.rvKategori.adapter = produkAdapter
        retrieveData()
    }

    private fun retrieveData() {
        APIConfig.apiInstance.dataProduk().enqueue(object : Callback<ProdukResponse> {
            override fun onResponse(
                call: Call<ProdukResponse>,
                response: Response<ProdukResponse>) {

                if (response.isSuccessful) {
                    var produkResponse = response.body()
                    var produkData = produkResponse?.data
                    var produkAdapter = ProdukAdapter(produkData as List<ProdukData>)
                    binding.rvKategori.apply {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        produkAdapter.notifyDataSetChanged()
                        adapter = produkAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ProdukResponse>, t: Throwable) {
                Log.e("HomeFragment", t.printStackTrace().toString())
            }
        })
    }
}