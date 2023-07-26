package com.aditd5.localshop.model



data class ProdukResponse (

    val data: List<ProdukData>,

    val kode: Int,

    val pesan: String
)


data class ProdukData(

    var id: Int,

    var nama: String,

    var jenis: String,

    var jumlah: String,

    var harga: String,

    var url: String
)