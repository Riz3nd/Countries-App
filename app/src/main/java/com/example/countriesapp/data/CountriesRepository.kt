package com.example.countriesapp.data

import javax.inject.Inject

class CountriesRepository @Inject constructor(private val service: CountriesService) {

    suspend fun getAllCountries(): String{
            return service.getAllCountries()
    }
    suspend fun getCountriesRegion(region: String): String{
        return service.getCountriesRegion(region)
    }
}