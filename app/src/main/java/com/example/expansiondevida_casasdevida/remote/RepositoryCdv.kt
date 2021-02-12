package com.example.expansiondevida_casasdevida.remote

import android.icu.text.IDNA
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.expansiondevida_casasdevida.local.CdvDao
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida

class RepositoryCdv (private val dao: CdvDao) {

    private val services = RetrofitCasaDeVida.retrofitInstance()
    val liveDataCdvDao: LiveData<List<CasaDeVida>> = dao.getAllCasaDeVida()
    val listCasaDeVidaFavority = dao.getAllCasaDeVida()

    fun converterCdv(converterCdv: List<ResponseDataClass>): List<CasaDeVida> {
        val listEntityCdv: MutableList<CasaDeVida> = mutableListOf()
        converterCdv.map {
            listEntityCdv.add(CasaDeVida(it.nombre_lider))
        }

        return listEntityCdv
    }



    suspend fun getCdvWithCoroutines() {
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = RetrofitCasaDeVida.retrofitInstance().fetchCasadevidaList()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    Log.d("REPO", "$it")

                    dao.InsertAllfoto(converterCdv(it))
                }

                false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()}")
            }

        } catch (t: Throwable) {
            Log.e("ERROR COROUTINA", t.message.toString())
        }

    }




         fun getCDVById(id:String): LiveData<List<CasaDeVida>> {
         return dao.getAllCasaDeVida()

    }

}