package com.shivamjha.snackhungrys

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.shivamjha.snackhungrys.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.signUpText.setOnClickListener {
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}