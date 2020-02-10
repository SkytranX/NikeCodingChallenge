package com.example.nikecodingchallenge.repository

import com.example.nikecodingchallenge.repository.remote.RetrofitInstance

object Repository {
    suspend fun defineTerm(term: String) = RetrofitInstance.urbanService.defineTerm(term)
}