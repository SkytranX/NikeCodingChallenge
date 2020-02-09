package com.example.nikecodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nikecodingchallenge.model.DefinitionResponse
import com.example.nikecodingchallenge.repository.Repository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    private var _definitions: MutableLiveData<DefinitionResponse> = MutableLiveData()
    val definitions: LiveData<DefinitionResponse> = _definitions

    fun defineTerm(term: String) {
        val termDisposable = Repository.defineTerm(term)
            .subscribe({
                _definitions.value = it
            }, {
                // Error 
            })
        disposables.add(termDisposable)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}