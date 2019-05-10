package com.androidapp.kotlinweatherapp.presenter

import android.content.Context
import android.util.Log
import com.androidapp.kotlinweatherapp.model.CityList
import com.androidapp.kotlinweatherapp.view.WeatherView
import kotlinx.coroutines.*

class WeatherPresenter(var weatherInteractorImpl: WeatherInteractorImpl
                       ,var view:WeatherView?, var context:Context){

//    var view: WeatherView? = null
//
//    fun bind(view: WeatherView) {
//        this.view = view
//    }
//
//
//    fun unbind() {
//        view = null
//    }


    fun getWeatherData(zip: String, appid: String){

            CoroutineScope(Dispatchers.IO).launch {     // this launches a new coroutine and returns a reference to it as a Job instance.
            val request = weatherInteractorImpl.getData(zip, appid)

            //do something with result
            withContext(Dispatchers.Main){                          //dispatcher is used for performing blocking IO tasks use the Main dispatcher to perform work on the Main thread — this is so that we can update our UI with the retrieved data

                val response = request.await()                      //use the await() function to wait for the result of our request and then continue with our function body once a value has been received
                if(response.isSuccessful){
                    val cityList:CityList? = response.body()
                    Log.i("WeatherPresenter", cityList!!.list!!.size.toString())
                    Log.i("WeatherPresenter", cityList.city.name)

                    val weatherList = cityList.list
                    val city = cityList.city

                    view?.showWeatherData(cityList, weatherList, city)
                }

                else{
                    Log.i("WeatherPresenter", "Error: ${response.code()}")
                }


            }

        }


    }

}