package com.meezu.networkingassignment

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private var apiInstance: MyApi? = null

    private val okHttp = OkHttpClient.Builder()
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://universities.hipolabs.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttp)
        .build()

    fun getMyApi(): MyApi {
        if (apiInstance == null) {
            apiInstance = retrofit.create(MyApi::class.java)
        }
        return apiInstance ?: retrofit.create(MyApi::class.java)
    }

}