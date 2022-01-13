package com.demo.country.data.api

import com.demo.country.models.Country
import retrofit2.http.GET

interface ApiService {


    @GET("v3.1/region/asia")
    suspend fun getCountries(): List<Country>


}