package com.appserba.palugada.ui.masak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appserba.palugada.R

class MasakActivity : AppCompatActivity() {

   companion object{
       const val OPEN_MASAK="open_masak"
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masakk)
    }
}