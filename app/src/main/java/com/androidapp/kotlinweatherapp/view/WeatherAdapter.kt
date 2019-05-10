package com.androidapp.kotlinweatherapp.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidapp.kotlinweatherapp.R
import com.androidapp.kotlinweatherapp.model.WeatherList

class WeatherAdapter(val weatherList: List<WeatherList>?) : RecyclerView.Adapter<WeatherAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WeatherAdapter.CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val itemView = layoutInflater.inflate(R.layout.weather_list_item, p0, false )
        return CustomViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return weatherList!!.size
    }

    override fun onBindViewHolder(p0: WeatherAdapter.CustomViewHolder, p1: Int) {
    }

    class CustomViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

    }
}