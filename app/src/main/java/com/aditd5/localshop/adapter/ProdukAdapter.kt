package com.aditd5.localshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.aditd5.localshop.adapter.ProdukAdapter.HolderProduk
//import com.aditd5.localshop.model.ProdukModel
import com.aditd5.localshop.R
import com.aditd5.localshop.activity.home.HomeFragment
import com.aditd5.localshop.model.ProdukData

class ProdukAdapter(
    private val listProduk: List<ProdukData>):
    RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.card_produk, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var produkModel = listProduk[position]
        holder.vId.text = produkModel.id.toString()
        holder.vNama.text = produkModel.nama
        holder.vJenis.text = produkModel.jenis
        holder.vJumlah.text = produkModel.jumlah
        holder.vHarga.text = produkModel.harga
        holder.vUrl.text = produkModel.url
    }

    override fun getItemCount(): Int {
        return listProduk.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var vId: TextView = view.findViewById(R.id.tv_id)
        var vNama: TextView = view.findViewById(R.id.tv_nama)
        var vJenis: TextView = view.findViewById(R.id.tv_jenis)
        var vJumlah: TextView = view.findViewById(R.id.tv_jumlah)
        var vHarga: TextView = view.findViewById(R.id.tv_harga)
        var vUrl: TextView = view.findViewById(R.id.tv_url)
    }
}

