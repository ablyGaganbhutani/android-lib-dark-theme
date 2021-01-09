package com.ablySoft.darklighttheme.utils

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import com.ablySoft.darklighttheme.R

interface UtilityDarkModeMethods {

    fun changeDarkTextViewColor(color: Int, vararg view: View) {}


    // to change the tint color of image drawable with colorOnSurface given in colors files
    fun Context.changeDarkDrawableTintColor(
        vararg view: ImageView
    ) {
        val value = TypedValue()
        this.theme.resolveAttribute(R.attr.colorOnSurface, value, true)
        val color = value.data
        for (imageView in view) {
            imageView.setColorFilter(color)
        }
    }

    // to change the tint color of image drawable with custom color
    fun Context.changeDarkDrawableTintColor(
        color: Int,
        vararg view: ImageView
    ) {
        for (imageView in view) {
            imageView.setColorFilter(color)
        }
    }

    fun Context.changeViewBackgroundColor(vararg view: View) {
        val value = TypedValue()
        this.theme.resolveAttribute(R.attr.colorOnSurface, value, true)
        val color = value.data
        for (viewback in view) {
            viewback.setBackgroundColor(color)
        }
    }
}