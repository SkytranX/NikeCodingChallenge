package com.example.nikecodingchallenge.repository.remote

import com.example.nikecodingchallenge.model.DefinitionResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UrbanDictionaryService {

    @Headers(
        "$HEADER_HOST$HEADER_HOST_VALUE",
        "$HEADER_API_KEY$HEADER_API_KEY_VALUE"
    )
    @GET(SEARCH_PATH)
    suspend fun defineTerm(@Query(value = "term") term: String): DefinitionResponse

    companion object {
        const val SEARCH_PATH = "/define"
        const val HEADER_API_KEY = "x-rapidapi-key: "
        const val HEADER_API_KEY_VALUE = "3dee3aef91msh363dcc1c096fcaap1b0ac6jsnc193da2a47e9"
        const val HEADER_HOST = "x-rapidapi-host: "
        const val HEADER_HOST_VALUE = "mashape-community-urban-dictionary.p.rapidapi.com"
    }
}