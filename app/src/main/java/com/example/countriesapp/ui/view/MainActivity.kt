package com.example.countriesapp.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.countriesapp.R
import com.example.countriesapp.ui.viewmodel.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val contriesViewModel: CountriesViewModel by viewModels()
    private lateinit var tvJson:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvJson = findViewById(R.id.tvJson)

        //contriesViewModel.onCreate()
        contriesViewModel.getCountriesByRegion("america")
        contriesViewModel.countriesByRegion.observe(this, Observer {
            CoroutineScope(Dispatchers.Main).async { tvJson.text = it }
        })
        /*contriesViewModel.countries.observe(this, Observer {
            CoroutineScope(Dispatchers.Main).async { tvJson.text = it }
        })*/

    }
}