package com.example.nikecodingchallenge.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikecodingchallenge.R
import com.example.nikecodingchallenge.adapter.DictionaryAdapter
import com.example.nikecodingchallenge.extensions.parseDate
import com.example.nikecodingchallenge.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_search_word.view.*

/**
 * A simple [Fragment] subclass.
 */
class SearchWordFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    private var adapter: DictionaryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search_word, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = DictionaryAdapter()
        view.apply {
            wordInput.setText("Jawn")
            btnSearch.setOnClickListener {
                viewModel.defineTerm(wordInput.text.toString())
            }
            recyclerDictionary.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@SearchWordFragment.adapter
            }
        }
    }

    override fun onStart() {
        super.onStart()
        wordInputObservable()
    }

    private fun wordInputObservable() {
        viewModel.definitions.observe(this, Observer {
            println("PRINTING DATE FORMAT")
            println("FROM -> ${it.list[0].written_on}")
            println(
                "TO -> ${it.list[0].written_on.parseDate()}"
            )
            adapter?.submitList(it.list)
        })
    }
}
