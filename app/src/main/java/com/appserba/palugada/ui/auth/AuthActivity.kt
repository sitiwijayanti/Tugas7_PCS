package com.appserba.palugada.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appserba.palugada.R
import com.appserba.palugada.data.model.AuthUser
import com.appserba.palugada.databinding.ActivityAuthBinding
import com.appserba.palugada.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_auth)
//        setContentView(R.layout.activity_auth)
    }

    fun onSuccess(user:AuthUser?){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}