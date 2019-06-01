package com.androidapp.kotlinweatherapp.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.androidapp.kotlinweatherapp.R
import com.androidapp.kotlinweatherapp.model.City
import com.androidapp.kotlinweatherapp.presenter.WeatherInteractorImpl
import com.androidapp.kotlinweatherapp.presenter.WeatherPresenter
import com.androidapp.kotlinweatherapp.model.CityList
import com.androidapp.kotlinweatherapp.model.Weather
import com.androidapp.kotlinweatherapp.model.WeatherList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_weather_detail.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var spinnerSelection: String = ""
    var zipCode = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zip_code.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {

                //Get zip code from editText
                zipCode = zip_code.editableText.toString().trim()

                //Hide soft keyboard
                val inputManager:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.SHOW_FORCED)

                return@OnKeyListener true
            }
            false
        })


        //Get selected value from spinner
        //Spinner start
        val spinnerArray = arrayOf("Celsius", "Fahrenheit")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Please select a value", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, spinnerArray[position], LENGTH_LONG).show()
                spinnerSelection = spinnerArray[position]
            }
        }
        //Spinner end

        //Add data bundle to fragment and start transaction
        val bundle = Bundle()
        val weatherDetailFragment = WeatherDetailFragment()

        //Search button click listener
        search_button.setOnClickListener {
            weatherDetailFragment.arguments.apply { bundle.putString("ZIPCODE", zipCode) }
            weatherDetailFragment.arguments.apply { bundle.putString("SPINNER", spinnerSelection) }
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, weatherDetailFragment)
                .addToBackStack(null)
                .commit()
        }
    }

}

