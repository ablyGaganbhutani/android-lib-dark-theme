package com.ablySoft.darklighttheme.utils

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.ablySoft.darklighttheme.R


class DarkThemeImageView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attr, defStyleAttr) {


    companion object {
        private const val DRAWABLE_TINT_COLOR = 0
    }

    private var drawableTintColor = DRAWABLE_TINT_COLOR

    init {
        val typedArray = context.obtainStyledAttributes(attr, R.styleable.DarkThemeImageView)
        drawableTintColor = typedArray.getInt(
            R.styleable.DarkThemeImageView_drawableTint,
            DRAWABLE_TINT_COLOR
        )
        typedArray.recycle()

        backgroundTintList = when (drawableTintColor) {
            0 -> {
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.colorOnSurface))
            }
            else -> {
                ColorStateList.valueOf(drawableTintColor)
            }
        }
    }
}