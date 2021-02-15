package com.example.expansiondevida_casasdevida.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName= "casadevida_table")
data class CasaDeVida(
    @PrimaryKey val id: String,

    @SerializedName("foto")
    val foto: String,

    @SerializedName("nombre_lider")
    val nombre_lider: String,

    @SerializedName("dia")
    val dia: String,

    @SerializedName("hora")
    val hora: String,

    @SerializedName("direccion")
    val direccion: String,

    @SerializedName("comuna")
    val comuna: String,

    @SerializedName("celular")
    val celular: String,
    @SerializedName("correo")
    val correo: String,)

