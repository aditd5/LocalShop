package com.aditd5.localshop.data

var categoryList = mutableListOf<HomeCategory>()

class HomeCategory (

    var image: Int,
    var name: String,
    val id: Int = categoryList.size

)