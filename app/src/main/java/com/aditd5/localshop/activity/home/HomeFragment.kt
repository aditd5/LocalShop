package com.aditd5.localshop.activity.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditd5.localshop.ProductActivity
import com.aditd5.localshop.R
import com.aditd5.localshop.activity.MapsFragment
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

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


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

        binding.btnProduct.setOnClickListener {
            val intent = Intent(context, ProductActivity::class.java)
            startActivity(intent)
        }

        binding.ivMaps.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_home_content, MapsFragment())
            transaction.commit()
        }
    }
}