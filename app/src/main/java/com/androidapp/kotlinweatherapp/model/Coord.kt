package com.androidapp.kotlinweatherapp.model

import com.google.gson.annotations.SerializedName

class Coord (
    @SerializedName("lat") val lat:Double,
    @SerializedName("lon") val lon:Double
)