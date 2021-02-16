package com.example.expansiondevida_casasdevida.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.expansiondevida_casasdevida.local.CdvBD
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida
import com.example.expansiondevida_casasdevida.remote.RepositoryCdv
import kotlinx.coroutines.launch

class ViewModelCdv (application: Application) : AndroidViewModel(application) {

    private val repositoryCdv: RepositoryCdv
    val liveDataFromCdv: LiveData<List<CasaDeVida>>

    init {
        val dao = CdvBD.getEntityDB(application).getCdv()
        repositoryCdv = RepositoryCdv(dao)
        viewModelScope.launch {
            repositoryCdv.getCdvWithCoroutines()
        }

        liveDataFromCdv = repositoryCdv.liveDataCdvDao
        Log.d("livedata","$liveDataFromCdv")

    }

     fun getListCasaDeVida(name:String):LiveData<List<CasaDeVida>> = repositoryCdv.getcasaDeVida(name)

    //fun getAllFavCasaDeVida(): LiveData<List<CasaDeVida>> = repositoryCdv.listCasaDeVidaFavority
       //fav from dataBase



    fun getCdvWhithCoroutines(name:String) = viewModelScope.launch {
        repositoryCdv.getcasaDeVida(name)
    }

}
