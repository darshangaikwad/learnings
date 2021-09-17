package com.darshangaikwad.mylearning.photos

import com.squareup.moshi.Json

/**
 * Created by Darshan Gaikwad on 17,September,2021
 */
data class MarsPhoto(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)