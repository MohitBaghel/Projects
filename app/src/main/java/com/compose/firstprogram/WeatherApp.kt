package com.compose.firstprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import com.compose.firstprogram.dataclassw.WeatherAppData
import com.compose.firstprogram.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApp : AppCompatActivity() {
 // https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
    // 48a68b91f23e976a9078e42ad0cea974

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_app)
        try{
            fetchWeatherData()
        } catch (e : Exception){
            Log.d("Tag", e.toString())
        }
    }

    // network


    fun fetchWeatherData(){
        val retrofit =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface :: class.java)

        val response =  retrofit.getWeatherData("Delhi"," 48a68b91f23e976a9078e42ad0cea974", "metric")
        response.enqueue(object : Callback<WeatherAppData>{
            override fun onResponse(call: Call<WeatherAppData>, response: Response<WeatherAppData>) {
                TODO("Not yet implemented")
                val responseBody = response.body()
                if(responseBody != null){
                    val temp = responseBody.main.temp
                    Log.d("TAG","temp : $temp")
//                    need to assign temp to that specific is
//                    temperature.text = temp
                }
            }

            override fun onFailure(call: Call<WeatherAppData>, response: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}