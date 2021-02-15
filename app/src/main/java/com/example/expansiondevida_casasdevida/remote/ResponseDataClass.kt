package com.example.expansiondevida_casasdevida.remote

import com.google.gson.annotations.SerializedName

data class ResponseDataClass(@SerializedName("list") val list: List<DataClassRes>)