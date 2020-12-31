package com.appserba.palugada.data.repository

import com.appserba.palugada.data.model.ActionState
import com.appserba.palugada.data.model.Masak
import com.appserba.palugada.data.remote.MasakService
import com.appserba.palugada.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class MasakRepository {

    private val masakService: MasakService by lazy { RetrofitApi.masakService() }

    suspend fun listMasak() : ActionState<List<Masak>> {
        return try {
            val list = masakService.listMasak().await()
            ActionState(list.results)
        } catch (e : Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailMasak(url: String) : ActionState<Masak> {
        return try {
            val list = masakService.detailMasak(url).await()
            ActionState(list.results.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchMasak(query: String) : ActionState<List<Masak>> {
        return try {
            val list = masakService.searchMasak(query).await()
            ActionState(list.results)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

}