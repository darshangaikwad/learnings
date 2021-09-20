package com.darshangaikwad.mylearning.photos

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.darshangaikwad.mylearning.R

/**
 * Created by Darshan Gaikwad on 17,September,2021
 */

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_error)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<MarsPhoto>?
) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageview: ImageView, status: MarsApiStatus?) {
    when (status) {
        MarsApiStatus.LOADING -> {
            statusImageview.visibility = View.VISIBLE
            statusImageview.setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.ERROR -> {
            statusImageview.visibility = View.VISIBLE
            statusImageview.setImageResource(R.drawable.ic_connection_error)
        }
        MarsApiStatus.DONE -> {
            statusImageview.visibility = View.GONE
        }
    }
}