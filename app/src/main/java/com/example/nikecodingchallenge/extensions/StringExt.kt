package com.example.nikecodingchallenge.extensions

import java.text.SimpleDateFormat
import java.util.*

const val DEFAULT_INPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val DEFAULT_OUTPUT_FORMAT = "yyyy-MM-dd"

fun String.parseDate(
    inputFormat: String = DEFAULT_INPUT_FORMAT,
    outputFormat: String = DEFAULT_OUTPUT_FORMAT
): String =
    SimpleDateFormat(inputFormat, Locale.getDefault()).parse(this)?.let {
        SimpleDateFormat(outputFormat, Locale.getDefault()).format(it)
    } ?: this