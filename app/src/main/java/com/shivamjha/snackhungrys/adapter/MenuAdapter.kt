package com.shivamjha.snackhungrys.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivamjha.snackhungrys.databinding.MenuItemBinding

class MenuAdapter(private val menuItems:MutableList<String>,
                  private val menuItemPrice:MutableList<String>,
                  private val menuImages:MutableList<Int>):
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

//    fun updateData(
//        foodNames: List<String>,
//        foodPrices: List<String>,
//        foodImages: List<Int>
//    ) {
//        this.foodNames.clear()
//        this.foodPrices.clear()
//        this.foodImages.clear()
//
//        this.foodNames.addAll(foodNames)
//        this.foodPrices.addAll(foodPrices)
//        this.foodImages.addAll(foodImages)
//
//        notifyDataSetChanged()
//    }


    inner class MenuViewHolder(private val binding:MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

            binding.apply {
                menuFoodName.text = menuItems[position]
                menuPrice.text = menuItemPrice[position]
                menuImage.setImageResource(menuImages[position])
            }

        }

    }
}