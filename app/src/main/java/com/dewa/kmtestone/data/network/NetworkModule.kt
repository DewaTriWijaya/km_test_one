package com.dewa.kmtestone.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val API_KEY_HEADER = "x-api-key"
    private const val API_KEY_VALUE  = "reqres-free-v1"

    private val authInterceptor = Interceptor { chain ->
        val newRequest = chain.request()
            .newBuilder()
            .addHeader(API_KEY_HEADER, API_KEY_VALUE)
            .build()
        chain.proceed(newRequest)
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
