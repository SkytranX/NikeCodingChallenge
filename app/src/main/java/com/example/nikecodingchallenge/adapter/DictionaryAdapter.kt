package com.example.nikecodingchallenge.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.nikecodingchallenge.R
import com.example.nikecodingchallenge.databinding.KeyInfoBinding
import com.example.nikecodingchallenge.extensions.bind
import com.example.nikecodingchallenge.model.Definition


class DictionaryAdapter : DataBoundListAdapter<Definition>(
    diffCallback = object : DiffUtil.ItemCallback<Definition>() {
        override fun areItemsTheSame(oldItem: Definition, newItem: Definition): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Definition, newItem: Definition): Boolean =
            oldItem == newItem

    }
) {
    var onClick: View.OnClickListener? = null

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =
        parent.bind(R.layout.key_info)

    override fun bind(binding: ViewDataBinding, item: Definition) {
        when (binding) {
            is KeyInfoBinding -> binding.definition = item
        }
        binding.root.tag = item
        binding.root.setOnClickListener(onClick)
    }
}