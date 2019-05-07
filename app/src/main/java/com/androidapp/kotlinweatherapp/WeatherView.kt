package com.androidapp.kotlinweatherapp

import com.androidapp.kotlinweatherapp.model.CityList

interface WeatherView {

    fun updateUI(cityList:CityList)
}