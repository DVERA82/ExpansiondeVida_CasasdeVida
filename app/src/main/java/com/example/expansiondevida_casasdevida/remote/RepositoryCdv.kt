package com.example.expansiondevida_casasdevida.remote

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.expansiondevida_casasdevida.local.CdvDao
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida

class RepositoryCdv (private val dao: CdvDao) {

    private val services = RetrofitCasaDeVida.retrofitInstance()
    val liveDataCdvDao: LiveData<List<CasaDeVida>> = dao.getAllCasaDeVida()
    val listFavouriteFoto= dao.getAllFavouriteFoto()



    fun converterCdv(converterCdv: List<DataClassRes>): List<CasaDeVida> {
        val listEntityCdv: MutableList<CasaDeVida> = mutableListOf()
        converterCdv.map {
            listEntityCdv.add(CasaDeVida(id = it.id, nombre_lider = it.nombre_lider, foto = it.foto,
                    dia = it.dia, hora = it.hora, direccion = it.direccion, comuna = it.comuna,
                    celular = it.celular, correo = it.correo, favourite = it.Favourite))
        }

        return listEntityCdv
    }

    suspend fun getCdvWithCoroutines() {

        try {
            val response = RetrofitCasaDeVida.retrofitInstance().fetchCasadevidaList()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    Log.d("REPO", "$it")

                    dao.InsertAllfoto(converterCdv(it.list))
                }

                false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()}")
            }

        } catch (t: Throwable) {
            Log.e("ERROR COROUTINA", t.message.toString())
        }

    }

    fun getcasaDeVida(name: String): LiveData<List<CasaDeVida>> = dao.getAllCdv(name)

   suspend fun updateFavouritefoto(casaDeVida: CasaDeVida) {
       dao.updateCasaDeVida(casaDeVida)
   }

}