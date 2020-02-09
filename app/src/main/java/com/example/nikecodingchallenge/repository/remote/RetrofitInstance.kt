package com.example.nikecodingchallenge.repository.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val INSTANCE: Retrofit = Retrofit.Builder()
        .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    fun getUrbanDictionaryService(): UrbanDictionaryService {
        return INSTANCE.create(UrbanDictionaryService::class.java)
    }
}