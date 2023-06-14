package com.aditd5.localshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aditd5.localshop.data.HomeCategory
import com.aditd5.localshop.HomeCategoryViewHolder
import com.aditd5.localshop.databinding.CardCategoryBinding

class HomeCategoryAdapter (private val category: List<HomeCategory>)
    : RecyclerView.Adapter<HomeCategoryViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCategoryBinding.inflate(from,parent,false)
        return HomeCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
         return category.size
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.bindCategory(category[position])
    }

}