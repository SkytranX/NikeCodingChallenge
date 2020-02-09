package com.example.nikecodingchallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.nikecodingchallenge.R
import com.example.nikecodingchallenge.databinding.KeyInfoBinding
import com.example.nikecodingchallenge.model.Definition


class DictionaryAdpater : DataBoundListAdapter<Definition>(
    diffCallback = object : DiffUtil.ItemCallback<Definition>() {
        override fun areItemsTheSame(oldItem: Definition, newItem: Definition): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Definition, newItem: Definition): Boolean =
            oldItem == newItem

    }
) {
    var onClick: View.OnClickListener? = null

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.key_info,
            parent,
            false
        )

    override fun bind(binding: ViewDataBinding, item: Definition) {
        when (binding) {
            is KeyInfoBinding -> binding.definition = item
        }
        binding.root.tag = item
        binding.root.setOnClickListener(onClick)
    }
}
/*
 viewGroup.searchWord.text = dictionaryList[viewType].word
        viewGroup.wrdDefinition.text = dictionaryList[viewType].definition
        viewGroup.wrdExample.text = dictionaryList[viewType].example
        viewGroup.thumbsUpVal.text = dictionaryList[viewType].thumbs_up.toString()
        viewGroup.thumbsDownVal.text = dictionaryList[viewType].thumbs_down.toString()
}*/
