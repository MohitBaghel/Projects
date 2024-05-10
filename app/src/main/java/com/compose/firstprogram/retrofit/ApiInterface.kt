package com.compose.firstprogram.retrofit

import com.compose.firstprogram.dataclassw.WeatherAppData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather")
    fun getWeatherData(
        @Query("q") city : String,
        @Query("appid") appid: String,
        @Query("units") units: String
    ) : Call<WeatherAppData>

}