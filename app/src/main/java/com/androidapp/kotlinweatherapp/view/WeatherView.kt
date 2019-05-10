package com.androidapp.kotlinweatherapp.view

import com.androidapp.kotlinweatherapp.model.*

interface WeatherView {

//    fun updateUI(cityList:CityList)

//    fun saveWeatherData(country:String,
//                        humidity:String,
//                        maxTamp:String,
//                        minTemp:String,
//                        pressure:String,
//                        speed:String,
//                        deg:String,
//                        cloudAll:String,
//                        temp:String,
//                        current:String)

    fun showWeatherData(
        cityList: CityList,
        weatherList: List<WeatherList>?,
        city:City
    )
}