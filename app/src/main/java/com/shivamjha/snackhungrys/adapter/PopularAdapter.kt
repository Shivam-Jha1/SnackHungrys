package com.shivamjha.snackhungrys.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivamjha.snackhungrys.databinding.PopularItemBinding

class PopularAdapter(private val items:List<String>,private val image:List<Int>,private val price:List<String>): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,images,price)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class PopularViewHolder (private val binding:PopularItemBinding):RecyclerView.ViewHolder(binding.root){

        val imageView = binding.foodImagePopular

        fun bind(item: String, images: Int,price:String) {
            binding.foodNamePopular.text = item
            binding.foodPricePopular.text = price
            imageView.setImageResource(images)
        }

    }
}