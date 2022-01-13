package com.demo.country.utils

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageUrl")
fun setImageUrl(iv: ImageView?, url: String?) {
    iv?.let {
        Log.d("IMAGE", url.toString())
        if (!url.isNullOrEmpty()) {
            Glide.with(it.context).load(url).into(iv)
        }
    }
}