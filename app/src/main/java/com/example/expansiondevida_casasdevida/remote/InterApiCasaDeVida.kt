package com.example.expansiondevida_casasdevida.remote

import retrofit2.Response
import retrofit2.http.GET

interface InterApiCasaDeVida {

    @GET ("casasdeVida")
    suspend fun fetchCasadevidaList(): Response<ResponseDataClass>
}

