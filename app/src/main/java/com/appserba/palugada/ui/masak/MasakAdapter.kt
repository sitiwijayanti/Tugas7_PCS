package com.appserba.palugada.ui.masak

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appserba.palugada.R
import com.appserba.palugada.data.model.Masak
import com.appserba.palugada.databinding.ItemMasakBinding
import com.appserba.palugada.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class MasakAdapter(val context: Context) : BaseAdapter<Masak>(R.layout.item_masak){
    override fun onBind(binding: ViewDataBinding?, data: Masak) {
        val mBinding = binding as ItemMasakBinding
        Glide.with(context).load(data.thumb).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: Masak) {
        val intent = Intent(context, MasakActivity::class.java)
        intent.putExtra(MasakActivity.OPEN_MASAK, data)
        context.startActivity(intent)
    }
}