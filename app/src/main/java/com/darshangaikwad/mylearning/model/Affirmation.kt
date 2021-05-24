package com.darshangaikwad.mylearning.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by Darshan Gaikwad on 24,May,2021
 */
data class Affirmation(@StringRes val stringResourceId: Int, @DrawableRes val imageResourceId: Int)
