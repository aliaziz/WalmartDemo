package com.miu.mdp.walmartdemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miu.mdp.walmartdemo.databinding.ActivityCategoryListBinding
import com.miu.mdp.walmartdemo.databinding.ListItemBinding

class CategoryList : AppCompatActivity() {
    private lateinit var binder: ActivityCategoryListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityCategoryListBinding.inflate(layoutInflater)
        setContentView(binder.root)

        with(binder) {
            recycler.layoutManager = LinearLayoutManager(this@CategoryList)
            recycler.adapter = CatAdapter(
                arrayListOf(
                    Product(
                        "RGA Voyager 7 16GB Android Tablet",
                        35.00,
                        "Black",
                        itemId = "5551883493",
                        desc = "Create RecyclerListView for the Electronics Items as mentioned below. [ 20 Points]\n" +
                                "If the user clicks the item from the list, you have to show the detailed view as shown in the\n" +
                                "screen below",
                        image = R.drawable.lcd
                    ),
                    Product(
                        "HP Flyer Red 15.6 Laptop",
                        299.00,
                        "Black & Red",
                        itemId = "5551883493",
                        desc = "Create RecyclerListView for the Electronics Items as mentioned below. [ 20 Points]\n" +
                                "If the user clicks the item from the list, you have to show the detailed view as shown in the\n" +
                                "screen below",
                        image = R.drawable.jacket
                    )
                ),
                this@CategoryList
            )
        }
    }
}

class CatAdapter(
    private val list: List<Product>,
    private val context: Context
) :
    RecyclerView.Adapter<CatAdapter.OurViewHolder>() {

    class OurViewHolder(view: ListItemBinding) : RecyclerView.ViewHolder(view.root) {
        val title = view.titleLabel
        val price = view.price
        val color = view.color
        val layout = view.layout
        val imageView = view.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OurViewHolder {
        val holder = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OurViewHolder(holder)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: OurViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.price.text = "Price: ${list[position].price}"
        holder.color.text = "Color: ${list[position].color}"

        holder.imageView.setImageDrawable(
            ResourcesCompat.getDrawable(context.resources, list[position].image, null))

        holder.layout.setOnClickListener {
            Intent(context, CategoryDetails::class.java).also {
                it.putExtra("product", list[position])
                context.startActivity(it)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}
