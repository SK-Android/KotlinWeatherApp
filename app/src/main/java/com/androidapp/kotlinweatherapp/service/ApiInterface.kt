package com.androidapp.kotlinweatherapp.service

import com.androidapp.kotlinweatherapp.model.CityList
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("forecast?")
    fun getWeatherData(
        @Query("zip") zip:String,
        @Query("appid") appid:String
    ): Deferred<Response<CityList>>
}

//api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}
//https://api.openweathermap.org/data/2.5/forecast?zip=37221&appid=9d02799fe291e3840cda7eb24fcfd2a1