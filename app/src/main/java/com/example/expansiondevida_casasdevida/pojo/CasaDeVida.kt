package com.example.expansiondevida_casasdevida.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName= "casadevida_table")
data class CasaDeVida(@PrimaryKey val list: String)

