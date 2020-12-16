package com.ablySoft.darklighttheme.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.ablySoft.darklighttheme.R

abstract class UtilityDarkModeMethods {

    fun changeDarkTextViewColor(vararg view: View, color: Int) {}

    fun Context.changeDarkDrawableTintColor(
        vararg view: ImageView,
        color: Int = ContextCompat.getColor(
            this,
            R.color.colorOnSurface
        )
    ) {
        for (imageView in view) {
            imageView.setColorFilter(color)
        }
    }
}