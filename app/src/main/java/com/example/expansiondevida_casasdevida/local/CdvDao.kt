package com.example.expansiondevida_casasdevida.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida
import androidx.room.Query


@Dao
interface CdvDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertAllfoto(lista: List<CasaDeVida>)

    @Query("SELECT * FROM casadevida_table ")
    fun getAllCasaDeVida(): LiveData<List<CasaDeVida>>

    //@Query("SELECT  * FROM   casadevida_table")
    //fun getAllCdvBD():LiveData<List<CasaDeVida>>


    @Query("SELECT * FROM casadevida_table WHERE id=:name")
    fun getAllCdv(name: String): LiveData<List<CasaDeVida>>



}





