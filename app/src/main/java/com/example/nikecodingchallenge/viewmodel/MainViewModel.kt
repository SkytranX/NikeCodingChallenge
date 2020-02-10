package com.example.nikecodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.nikecodingchallenge.model.DefinitionResponse
import com.example.nikecodingchallenge.repository.Repository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val job = SupervisorJob()
    private val coroutineContext = Dispatchers.IO + job
    private val repo = Repository

    private var _definitions: MutableLiveData<DefinitionResponse> = MutableLiveData()
    val definitions: LiveData<DefinitionResponse> = _definitions


    fun defineTerm(term: String) = liveData(Dispatchers.IO) {
        println("STARTING TO FETCH DEFINE TERM")
        val definitionResponse = repo.defineTerm(term)
        println("ENDING FETCH")
        println(definitionResponse.toString())
        emit(definitionResponse)
    }
}