package com.meezu.networkingassignment

import io.reactivex.Single
import retrofit2.http.GET

interface MyApi {

    @GET("search?country=United+States")
    fun getAllUniversities(): Single<ArrayList<University>>
}