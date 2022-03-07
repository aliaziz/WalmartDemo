package com.miu.mdp.walmartdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.walmartdemo.databinding.ActivityShoppingCategoryBinding

class ShoppingCategory : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingCategoryBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            userName.text = "Welcome " + intent.extras?.getString("username")

            clothing.setOnClickListener {
                toast(ActivityShoppingCategoryBinding::clothing.name)
            }
            electronics.setOnClickListener {
                toast(ActivityShoppingCategoryBinding::electronics.name)
                Intent(this@ShoppingCategory, CategoryList::class.java).also {
                    startActivity(it)
                }
            }
            beauty.setOnClickListener {
                toast(ActivityShoppingCategoryBinding::beauty.name)
            }
            food.setOnClickListener {
                toast(ActivityShoppingCategoryBinding::food.name)
            }
        }
    }

    private fun toast(msg: String) =
        Toast.makeText(this, "You have chosen the $msg category of shopping", Toast.LENGTH_SHORT)
            .show()
}
