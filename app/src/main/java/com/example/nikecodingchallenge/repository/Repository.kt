package com.example.nikecodingchallenge.repository

import com.example.nikecodingchallenge.model.DefinitionResponse
import com.example.nikecodingchallenge.repository.remote.RetrofitInstance
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object Repository {
    fun defineTerm(term: String): Observable<DefinitionResponse> =
        RetrofitInstance.getUrbanDictionaryService()
            .defineTerm(term)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}