package com.aditd5.localshop.activity.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aditd5.localshop.activity.ProductActivity
import com.aditd5.localshop.R
import com.aditd5.localshop.activity.MapsFragment
//import com.aditd5.localshop.data.HomeCategory
//import com.aditd5.localshop.adapter.HomeCategoryAdapter
//import com.aditd5.localshop.data.categoryList
import com.aditd5.localshop.databinding.FragmentHomeBinding


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

        binding.ivMap.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_home_content, MapsFragment())
            transaction.commit()
        }
    }
}