package com.shivamjha.snackhungrys.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivamjha.snackhungrys.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainFoodName:ArrayList<String>,
                      private val buyAgainFoodPrice:ArrayList<String>,
                      private val buyAgainFoodImg:ArrayList<Int>)
    :RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return buyAgainFoodName.size
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(buyAgainFoodName[position],buyAgainFoodPrice[position],buyAgainFoodImg[position])
    }

    class BuyAgainViewHolder(private val binding:BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(s: String, s1: String, i: Int) {
            binding.buyAgainFoodName.text = s
            binding.buyAgainFoodPrice.text = s1
            binding.buyAgainFoodImg.setImageResource(i)
        }

    }
}