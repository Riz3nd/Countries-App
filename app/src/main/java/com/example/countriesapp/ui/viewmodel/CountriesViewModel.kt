package com.example.countriesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.domain.CountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(private val countriesAll: CountriesUseCase): ViewModel() {
    var countries = MutableLiveData<String>()
    var countriesByRegion = MutableLiveData<String>()

    fun onCreate(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                countries.postValue(countriesAll.getAllCountries())
            }catch (e: Exception){ e.printStackTrace() }
        }
    }
    fun getCountriesByRegion(region: String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                countriesByRegion.postValue(countriesAll.getCountriesRegion(region))
            }catch (e: Exception){ e.printStackTrace() }
        }
    }
}