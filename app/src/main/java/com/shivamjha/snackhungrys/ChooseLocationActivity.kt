package com.shivamjha.snackhungrys

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.shivamjha.snackhungrys.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    lateinit var binding: ActivityChooseLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_choose_location)

        val locationList = arrayOf("Muzaffarpur","Patna","Samastipur","Darbhanga","Gaya","Motihari","Baruni","Hajipur")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView = binding.locationList
        autoCompleteTextView.setAdapter(adapter)
    }
}