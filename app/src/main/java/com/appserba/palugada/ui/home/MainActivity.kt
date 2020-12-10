package com.appserba.palugada.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appserba.palugada.R
import com.appserba.palugada.databinding.ActivityMainBinding
import com.appserba.palugada.ui.auth.AppserbaAuth
import com.appserba.palugada.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            AppserbaAuth.logout(this){
                startActivity(Intent(this,AuthActivity::class.java))
                finish()
            }
        }
    }
}