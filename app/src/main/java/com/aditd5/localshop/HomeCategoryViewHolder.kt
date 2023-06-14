package com.aditd5.localshop

import androidx.recyclerview.widget.RecyclerView
import com.aditd5.localshop.data.HomeCategory
import com.aditd5.localshop.databinding.CardCategoryBinding

class HomeCategoryViewHolder(
    private val cardCellBinding: CardCategoryBinding
) : RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindCategory(homeCategory: HomeCategory) {
        cardCellBinding.ivCategory.setImageResource(homeCategory.image)
        cardCellBinding.tvCategory.text = homeCategory.name
    }
}