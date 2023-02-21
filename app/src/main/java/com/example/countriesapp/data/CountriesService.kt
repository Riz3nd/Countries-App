package com.example.countriesapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountriesService @Inject constructor(private val api:CountriesApi){

    suspend fun getAllCountries(): String {
        return withContext(Dispatchers.IO){
            val response = api.getAllCountries()
            response.body().toString() ?: ""
        }
    }

    suspend fun getCountriesRegion(region: String): String {
        return withContext(Dispatchers.IO){
            val response = api.getCountriesByRegions(region)
            println("JSON: ${response.body()}")
            response.body().toString() ?: ""
        }
    }

}