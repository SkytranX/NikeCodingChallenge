package com.example.nikecodingchallenge.repository.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private const val BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com"
    private const val TIMEOUT = 100L

    private val interceptor: HttpLoggingInterceptor
        get() = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    private val okHttp: OkHttpClient
        get() = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

    private val INSTANCE: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()

    val urbanService: UrbanDictionaryService = INSTANCE.create(UrbanDictionaryService::class.java)
}