package com.kotlin.testkotlinapr2022.project1.network

import com.kotlin.testkotlinapr2022.project1.models.AllResultsModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {


    @GET("repositories")
    suspend fun userLogin(@Query("q") q: String): Response<AllResultsModel>

}