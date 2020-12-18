package com.ablySoft.darklighttheme.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.textview.MaterialTextView

class DarkThemeTextViews @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attr, defStyleAttr) {

    private var textColor = 0
    private var drawableTintColor = 0

}