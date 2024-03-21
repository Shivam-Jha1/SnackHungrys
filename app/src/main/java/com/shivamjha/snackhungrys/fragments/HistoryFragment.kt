package com.shivamjha.snackhungrys.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivamjha.snackhungrys.R
import com.shivamjha.snackhungrys.adapter.BuyAgainAdapter
import com.shivamjha.snackhungrys.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private lateinit var binding:FragmentHistoryBinding
    private lateinit var buyAgainAdapter:BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setUpRv()
        return binding.root
    }

    private fun setUpRv(){
        val buyAgainFoodName = arrayListOf("food1","food2","food3","food4","food5")
        val buyAgainFoodPrice = arrayListOf("$10","$10","$10","$10","$10")
        val buyAgainFoodImg = arrayListOf(R.drawable.banner3,R.drawable.banner3,R.drawable.banner3,R.drawable.banner3,R.drawable.banner3)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImg)

        binding.buyAgainRv.adapter = buyAgainAdapter
        binding.buyAgainRv.layoutManager = LinearLayoutManager(requireContext())
    }

}