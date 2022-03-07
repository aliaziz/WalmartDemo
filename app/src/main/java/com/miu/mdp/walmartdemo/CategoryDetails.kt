package com.miu.mdp.walmartdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.miu.mdp.walmartdemo.databinding.ActivityCategoryDetailsBinding
import com.miu.mdp.walmartdemo.databinding.ActivityCategoryListBinding

class CategoryDetails : AppCompatActivity() {
    private lateinit var binder: ActivityCategoryDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityCategoryDetailsBinding.inflate(layoutInflater)
        setContentView(binder.root)

        val product = intent.extras?.get("product") as Product

        with(binder) {
            color.text = product.color
            title.text = product.title
            productId.text = product.itemId
            desc.text = product.desc

            Glide.with(this@CategoryDetails)
                .load(product.image)
                .into(imageView)
        }
    }
}
