package com.example.nikecodingchallenge.extensions

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("displayDate")
fun TextView.displayDate(dateString: String) {
    text = dateString.parseDate()
}