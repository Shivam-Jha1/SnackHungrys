package com.shivamjha.snackhungrys

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the NavController associated with the NavHostFragment
        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
            ?.findNavController()

        // Verify that NavController is not null before setting up BottomNavigationView
        navController?.let { navController ->
            // Set up BottomNavigationView with the NavController
            findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                .setupWithNavController(navController)
        }
    }
}