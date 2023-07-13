package com.aditd5.localshop.api

import com.aditd5.localshop.model.ProdukData
import com.aditd5.localshop.model.ProdukResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface APIService {

    @GET("produk.php")
    fun dataProduk(): Call<ProdukResponse>
}