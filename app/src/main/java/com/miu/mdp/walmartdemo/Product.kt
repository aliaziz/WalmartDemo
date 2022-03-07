package com.miu.mdp.walmartdemo

import java.io.Serializable

data class Product(
    val title: String,
    val price: Double,
    val color: String,
    val image: Int = 0,
    val itemId: String = "",
    val desc: String = ""
): Serializable
