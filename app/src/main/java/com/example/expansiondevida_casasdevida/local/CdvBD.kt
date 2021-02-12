package com.example.expansiondevida_casasdevida.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida

@Database(entities = [CasaDeVida::class], version = 1 )
abstract class CdvBD : RoomDatabase (){

    abstract  fun getCdv(): CdvDao

    companion object {
        @Volatile
        private var INSTANCE: CdvBD? = null

        fun getEntityDB(context: Context): CdvBD {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    CdvBD::class.java, "CdvBD")
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }



}