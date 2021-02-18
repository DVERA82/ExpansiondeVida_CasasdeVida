package com.example.expansiondevida_casasdevida.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida


@Dao
interface CdvDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun InsertAllfoto(lista: List<CasaDeVida>)

    @Query("SELECT * FROM casadevida_table ")
    fun getAllCasaDeVida(): LiveData<List<CasaDeVida>>


    @Query("SELECT * FROM casadevida_table WHERE id=:name")
    fun getAllCdv(name: String): LiveData<List<CasaDeVida>>

    @Query("SELECT * FROM casadevida_table WHERE favourite = 1")
    fun getAllFavouriteFoto(): LiveData<List<CasaDeVida>>

    @Update
    suspend fun updateCasaDeVida(casaDeVida: CasaDeVida)



}





