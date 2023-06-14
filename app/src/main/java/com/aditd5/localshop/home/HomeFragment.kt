package com.aditd5.localshop.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.aditd5.localshop.data.HomeCategory
import com.aditd5.localshop.R
import com.aditd5.localshop.adapter.HomeCategoryAdapter
import com.aditd5.localshop.data.categoryList
import com.aditd5.localshop.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateCategory()
        binding.rvKategori.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = HomeCategoryAdapter(categoryList)
        }
    }

    private fun populateCategory() {
        val makanan = HomeCategory(
            R.drawable.ic_food,
            "Makanan"
        )
        categoryList.add(makanan)

        val minuman = HomeCategory(
            R.drawable.ic_drink,
            "Minuman"
        )
        categoryList.add(minuman)

        val perlatan_sekolah = HomeCategory(
            R.drawable.ic_school_equipment,
            "Peralatan Sekolah"
        )
        categoryList.add(perlatan_sekolah)

        val kebutuhan_harian = HomeCategory(
            R.drawable.ic_furniture,
            "Kebutuhan Harian"
        )
        categoryList.add(kebutuhan_harian)
    }

}