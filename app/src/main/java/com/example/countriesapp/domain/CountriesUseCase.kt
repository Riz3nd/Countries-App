package com.example.countriesapp.domain

import com.example.countriesapp.data.CountriesRepository
import javax.inject.Inject

class CountriesUseCase @Inject constructor(private val repository: CountriesRepository) {
    suspend fun  getAllCountries() = repository.getAllCountries()
    suspend fun  getCountriesRegion(region: String) = repository.getCountriesRegion(region)
}