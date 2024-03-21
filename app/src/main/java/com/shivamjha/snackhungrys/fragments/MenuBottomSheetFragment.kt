package com.shivamjha.snackhungrys.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shivamjha.snackhungrys.R
import com.shivamjha.snackhungrys.adapter.MenuAdapter
import com.shivamjha.snackhungrys.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment(){

    private lateinit var binding:FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.btnBack.setOnClickListener {
            dismiss()
        }

        val menuFoodName = mutableListOf("Burger", "Sandwich", "Momo", "Pizza","Burger", "Sandwich", "Momo", "Pizza","Burger", "Sandwich", "Momo", "Pizza")

        val menuFoodPrice = mutableListOf("₹60","₹45","₹50","₹100","₹60","₹45","₹50","₹100","₹60","₹45","₹50","₹100")
        val menuFoodImage = mutableListOf(
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2,
            R.drawable.banner2
        )

        val adapter = MenuAdapter(menuFoodName,menuFoodPrice,menuFoodImage)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }

}