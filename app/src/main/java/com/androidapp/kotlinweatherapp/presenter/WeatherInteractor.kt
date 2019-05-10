package com.androidapp.kotlinweatherapp.presenter

import com.androidapp.kotlinweatherapp.model.CityList
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface WeatherInteractor {

   suspend fun getData(zip:String, appid:String):Deferred<Response<CityList>>

}