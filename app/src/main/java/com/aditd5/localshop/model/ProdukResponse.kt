package com.aditd5.localshop.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProdukResponse (

    @field:SerializedName("result")
    val data: List<ProdukData?>? = null,

    @field:SerializedName("kode")
    val kode: Int = 0,

    @field:SerializedName("pesan")
    val pesan: String? = null
) : Parcelable


@Parcelize
data class ProdukData(

    @field:SerializedName("id")
    var id: Int = 0,

    @field:SerializedName("nama")
    var nama: String? = null,

    @field:SerializedName("jenis")
    var jenis: String? = null,

    @field:SerializedName("jumlah")
    var jumlah: String?  = null,

    @field:SerializedName("harga")
    var harga: String?  = null,

    @field:SerializedName("url")
    var url: String?  = null
) : Parcelable