package com.aditd5.localshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.aditd5.localshop.adapter.ProdukAdapter.HolderProduk
//import com.aditd5.localshop.model.ProdukModel
import com.aditd5.localshop.R
import com.aditd5.localshop.activity.home.HomeFragment
import com.aditd5.localshop.model.ProdukData
import com.squareup.picasso.Picasso

class ProdukAdapter(
    private val listProduk: List<ProdukData>
    ): RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.card_produk, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produkModel = listProduk[position]
        holder.Nama.text = produkModel.nama
        holder.Rating.text = produkModel.rating
        holder.Harga.text = ("Rp " + produkModel.harga)

        Picasso.get()
            .load(produkModel.url)
            .resize(150, 150)
            .centerCrop()
            .into(holder.Foto)

        holder.Foto.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return listProduk.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var Nama: TextView = view.findViewById(R.id.tv_nama)
        var Harga: TextView = view.findViewById(R.id.tv_harga)
        var Foto: ImageView = view.findViewById(R.id.iv_produk)
        var Rating: TextView = view.findViewById(R.id.tv_rating)
    }
}

