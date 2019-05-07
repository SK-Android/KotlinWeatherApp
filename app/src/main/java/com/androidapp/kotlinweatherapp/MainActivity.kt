package com.androidapp.kotlinweatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidapp.kotlinweatherapp.model.CityList

class MainActivity : AppCompatActivity(), WeatherView {

    lateinit var weatherInteractor:WeatherInteractorImpl
    lateinit var presenter:WeatherPresenter

    companion object {
        val appid = "9d02799fe291e3840cda7eb24fcfd2a1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherInteractor = WeatherInteractorImpl()
        presenter = WeatherPresenter(weatherInteractor, this)
        presenter.bind(this)
        presenter.getWeatherData("37221", appid)


    }

    override fun updateUI(cityList: CityList) {
        //add adapter code

    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

}
