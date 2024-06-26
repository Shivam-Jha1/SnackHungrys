package com.shivamjha.snackhungrys.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.shivamjha.snackhungrys.R
import com.shivamjha.snackhungrys.adapter.PopularAdapter
import com.shivamjha.snackhungrys.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.viewAllMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Menu")
        }

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_LONG).show()
            }
        })

        val foodName = listOf("Burger","Sandwich","Momo","Pizza","Burger","Sandwich","Momo","Pizza")
        val price = listOf("₹60","₹45","₹50","₹100","₹60","₹45","₹50","₹100")
        val foodImage = listOf(R.drawable.banner1,R.drawable.banner1,R.drawable.banner1,
            R.drawable.banner1,R.drawable.banner1,R.drawable.banner1,R.drawable.banner1,R.drawable.banner1)

        val adapter = PopularAdapter(foodName,foodImage,price)
        binding.popularFoodRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularFoodRecyclerView.adapter = adapter

    }
}