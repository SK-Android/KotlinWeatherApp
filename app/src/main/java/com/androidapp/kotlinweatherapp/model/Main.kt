package com.androidapp.kotlinweatherapp.model

import com.google.gson.annotations.SerializedName

class Main (
    @SerializedName("temp") val temp:Double,
    @SerializedName("temp_min") val tempMin:Double,
    @SerializedName("temp_max") val tempMax:Double,
    @SerializedName("pressure") val pressure:Double,
    @SerializedName("sea_level") val seaLevel:Double,
    @SerializedName("grnd_level") val grndLevel:Double,
    @SerializedName("humidity") val humidity:Int,
    @SerializedName("temp_kf") val temp_kf:Double
)