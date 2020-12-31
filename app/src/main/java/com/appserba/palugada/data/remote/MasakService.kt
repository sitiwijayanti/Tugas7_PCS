package com.appserba.palugada.data.remote

import com.appserba.palugada.data.model.MasakList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MasakService {
    @GET("recipes/")
    fun listMasak() : Call<MasakList>

    @GET("detail/")
    fun detailMasak(@Query("url")url: String) : Call<MasakList>

    @GET("search/")
    fun searchMasak(@Query("q")query: String): Call<MasakList>
}