package com.androidapp.kotlinweatherapp.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androidapp.kotlinweatherapp.R
import com.androidapp.kotlinweatherapp.model.WeatherList

class WeatherAdapter(val weatherList: List<WeatherList>?,
                     val spinnerSelection: String
) : RecyclerView.Adapter<WeatherAdapter.CustomViewHolder>(){



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WeatherAdapter.CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val itemView = layoutInflater.inflate(R.layout.weather_list_item, p0, false )
        return CustomViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return weatherList!!.size
    }

    override fun onBindViewHolder(p0: WeatherAdapter.CustomViewHolder, p1: Int) {

        p0.time.text = weatherList?.get(p1)!!.dtTxt
        val temp1 = weatherList.get(p1).main.temp.toInt()

        if(spinnerSelection == "Fahrenheit"){
            val temperature = (temp1*291.23 - 273.15)*1.8+32
            p0.degree.text = temperature.toString()
        }
       else{
            val temperature = (temp1*291.23) - 273.15
            p0.degree.text = temperature.toString()
        }

        //p0.time.text = weatherList?.get(p1)!!.dtTxt
    }

    class CustomViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        val time:TextView = itemView.findViewById(R.id.time)
        val weatherImage:ImageView = itemView.findViewById(R.id.weather_image)
        val degree:TextView = itemView.findViewById(R.id.degree)
    }
}