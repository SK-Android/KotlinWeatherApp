package com.androidapp.kotlinweatherapp.presenter

import com.androidapp.kotlinweatherapp.model.CityList
import com.androidapp.kotlinweatherapp.service.ApiInterface
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherInteractorImpl : WeatherInteractor {

    //we are calling a suspending operation within the function body
    // A suspending function is non-blocking and can be managed once
    // triggered — such as being started, paused, resumed and cancelled.

    override suspend fun getData(zip: String, appid: String): Deferred<Response<CityList>> {
        return makeService().getWeatherData(zip, appid)
    }


     fun makeService():ApiInterface{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}