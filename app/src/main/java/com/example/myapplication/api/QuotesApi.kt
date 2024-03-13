package com.example.myapplication.api

import com.example.myapplication.dataclass.Products
import com.example.myapplication.dataclass.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/products")
    suspend fun getQuotes() : Response<Products>
}