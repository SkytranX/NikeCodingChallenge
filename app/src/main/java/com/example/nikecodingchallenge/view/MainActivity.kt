package com.example.nikecodingchallenge.view

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikecodingchallenge.R
import com.example.nikecodingchallenge.adapter.DictionaryAdpater
import com.example.nikecodingchallenge.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.http.Tag

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
    private val adapter: DictionaryAdpater by lazy {
        DictionaryAdpater()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerDictionary.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainActivity.adapter
        }

        val wordInput: SearchView = findViewById(R.id.wordInput)
        val wordSearch: ImageButton = findViewById(R.id.btnSearch)


        wordSearch.setOnClickListener({
            viewModel.defineTerm(wordInput.toString())

            Toast.makeText(this, "Searched button pressed", Toast.LENGTH_SHORT).show()
        })

        wordInputObservable()

    }

    private fun wordInputObservable() {
        viewModel.definitions.observe(this, Observer {
            adapter.submitList(it.list)
            /*Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()*/

        })
    }


}
