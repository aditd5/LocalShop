package com.aditd5.localshop.api

//import com.google.gson.Gson
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//class APIRetrofit {
//
//    val endpoint: APIService
//        get() {
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//            val client = OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .build()
//
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://fplocalshop.000webhostapp.com/")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            return retrofit.create(APIService::class.java)
//        }
//}