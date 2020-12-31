package com.appserba.palugada.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Masak (
        val title: String = " ",
        val link: String = " ",
        val thumb: String = " ",
        val portion: String = " ",
        val times: String = " "
) : Parcelable