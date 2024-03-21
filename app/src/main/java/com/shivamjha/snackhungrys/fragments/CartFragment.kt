package com.shivamjha.snackhungrys.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivamjha.snackhungrys.R
import com.shivamjha.snackhungrys.adapter.CartAdapter
import com.shivamjha.snackhungrys.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var binding:FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val cartFoodName = mutableListOf("Burger", "Sandwich", "Momo", "Pizza")

        val cartFoodPrice = mutableListOf("₹60","₹45","₹50","₹100")
        val cartFoodImage = mutableListOf(R.drawable.banner2,R.drawable.banner2,R.drawable.banner2,R.drawable.banner2)

        val adapter = CartAdapter(cartFoodName,cartFoodPrice,cartFoodImage)
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
    }


}