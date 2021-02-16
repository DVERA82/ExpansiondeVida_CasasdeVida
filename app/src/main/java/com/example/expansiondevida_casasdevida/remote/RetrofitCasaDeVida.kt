package com.example.expansiondevida_casasdevida.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCasaDeVida {

    companion object{
        private const val URL_BASE ="https://demo1791984.mockable.io/"


        fun retrofitInstance(): InterApiCasaDeVida {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return  retrofit.create(InterApiCasaDeVida::class.java)

        }


    }
}