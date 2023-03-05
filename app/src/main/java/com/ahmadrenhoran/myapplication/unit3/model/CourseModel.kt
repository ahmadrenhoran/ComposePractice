package com.ahmadrenhoran.myapplication.unit3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val name: Int,  val totalStudent: Int, @DrawableRes val image: Int)
