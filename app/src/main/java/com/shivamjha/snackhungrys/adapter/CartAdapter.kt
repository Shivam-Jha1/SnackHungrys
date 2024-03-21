package com.shivamjha.snackhungrys.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivamjha.snackhungrys.databinding.CartItemBinding

class CartAdapter(
    private val cartItems:MutableList<String>,
    private val cartItemPrice:MutableList<String>,
    private var CartImage:MutableList<Int>)
    :RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

        private val itemQuantity = IntArray(cartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return  CartViewHolder(CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }


inner class CartViewHolder(private var binding: CartItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int) {

        binding.apply {
            val quantity = itemQuantity[position]
            foodName.text = cartItems[position]
            foodPrice.text = cartItemPrice[position]
            cartImg.setImageResource(CartImage[position])
            qntBtn.text = quantity.toString()

            minusBtn.setOnClickListener {
                decreaseQnt(position)
            }
            plusBtn.setOnClickListener {
                increaseQnt(position)
            }
            delBtn.setOnClickListener {
                val itemPosition = adapterPosition
                if(itemPosition!=RecyclerView.NO_POSITION) {
                    deleteQnt(itemPosition)
                }
            }
        }
    }
            private fun decreaseQnt(position: Int){
                if(itemQuantity[position]>1){
                    itemQuantity[position]--
                    binding.qntBtn.text = itemQuantity[position].toString()
                }
            }
            private fun increaseQnt(position: Int){
                if(itemQuantity[position]<10){
                    itemQuantity[position]++
                    binding.qntBtn.text = itemQuantity[position].toString()
                }
            }
            private fun deleteQnt(position: Int){
                cartItems.removeAt(position)
                cartItemPrice.removeAt(position)
                CartImage.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,cartItems.size)
            }
        }
}
