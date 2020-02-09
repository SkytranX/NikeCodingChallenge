package com.example.nikecodingchallenge.repository.remote

import com.example.nikecodingchallenge.constant.API_HOST
import com.example.nikecodingchallenge.constant.API_KEY
import com.example.nikecodingchallenge.constant.SEARCH_PATH
import com.example.nikecodingchallenge.model.DefinitionResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UrbanDictionaryService {

    @Headers(
        "x-rapidapi-host:$API_HOST",
        "x-rapidapi-key:$API_KEY"
    )
    @GET(SEARCH_PATH)
    fun defineTerm(@Query("term") term: String): Observable<DefinitionResponse>
}