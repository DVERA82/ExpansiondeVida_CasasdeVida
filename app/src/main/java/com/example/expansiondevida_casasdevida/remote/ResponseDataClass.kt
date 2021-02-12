package com.example.expansiondevida_casasdevida.remote

import com.google.gson.annotations.SerializedName

data class ResponseDataClass(
                        @SerializedName("id")
                        val id : String,

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
                        val correo: String )

