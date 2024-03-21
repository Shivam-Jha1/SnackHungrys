package com.shivamjha.snackhungrys.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
//import com.google.android.material.search.SearchView
import android.widget.SearchView
import com.shivamjha.snackhungrys.R
import com.shivamjha.snackhungrys.adapter.MenuAdapter
import com.shivamjha.snackhungrys.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding:FragmentSearchBinding
    private val originalFoodName = mutableListOf("Burger", "Sandwich", "Momo", "Pizza","Burger", "Sandwich", "Momo", "Pizza","Burger", "Sandwich", "Momo", "Pizza")
    private val originalFoodPrice = mutableListOf("₹60","₹45","₹50","₹100","₹60","₹45","₹50","₹100","₹60","₹45","₹50","₹100")
    private val originalFoodImage = mutableListOf(
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
    private lateinit var adapter:MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filterFoodName = mutableListOf<String>()
    private val filterFoodPrice = mutableListOf<String>()
    private val filterFoodImg = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filterFoodName,filterFoodPrice,filterFoodImg)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //Search View
        setUpSearchView()
        //show
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filterFoodName.clear()
        filterFoodPrice.clear()
        filterFoodImg.clear()

        filterFoodName.addAll(originalFoodName)
        filterFoodPrice.addAll(originalFoodPrice)
        filterFoodImg.addAll(originalFoodImage)
        adapter.notifyDataSetChanged()
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                // Handle the query submission, if needed
                filterMenuItem(query)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterMenuItem(p0)
                return true
            }

        })
    }

    private fun filterMenuItem(query: String?) {
        filterFoodName.clear()
        filterFoodPrice.clear()
        filterFoodImg.clear()

        originalFoodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query.toString(),ignoreCase = true)){
                filterFoodName.add(foodName)
                filterFoodPrice.add(originalFoodPrice[index])
                filterFoodImg.add(originalFoodImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


}
