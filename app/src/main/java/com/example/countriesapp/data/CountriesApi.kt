package com.example.countriesapp.data

import com.google.gson.JsonArray
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {
    @GET("all")
    suspend fun getAllCountries(): Response<JsonArray>
    @GET("region/{region}")
    suspend fun getCountriesByRegions(@Path("region") region: String): Response<JsonArray>
}