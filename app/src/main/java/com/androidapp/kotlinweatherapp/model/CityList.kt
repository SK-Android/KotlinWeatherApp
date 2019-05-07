package com.androidapp.kotlinweatherapp.model

import com.google.gson.annotations.SerializedName

class CityList (
    @SerializedName("cod") val cod:String,
    @SerializedName("message") val message:Double,
    @SerializedName("cnt") val cnt:Int,
    @SerializedName("list") val list:List<WeatherList>?,
    @SerializedName("city") val city:City
)