package com.example.nikecodingchallenge.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.nikecodingchallenge.R
import com.example.nikecodingchallenge.adapter.DictionaryAdapter
import com.example.nikecodingchallenge.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_search_word.view.*

/**
 * A simple [Fragment] subclass.
 */
class SearchWordFragment : Fragment() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private val adapter: DictionaryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search_word, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            wordInput.setText("Jawn")
            btnSearch.setOnClickListener {
                viewModel.defineTerm(wordInput.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        adapter?.submitList(it.list)
                    })
            }
            recyclerDictionary.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = DictionaryAdapter()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        wordInputObservable()
    }

    private fun wordInputObservable() {
        viewModel.definitions.observe(this, Observer {
            adapter?.submitList(it.list)
        })
    }
}
