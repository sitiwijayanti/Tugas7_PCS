package com.appserba.palugada.data.model

data class MasakList(
        val results : List<Masak> = arrayListOf(),
        val lenght : Int = 0,
        val status : Boolean = true
)
