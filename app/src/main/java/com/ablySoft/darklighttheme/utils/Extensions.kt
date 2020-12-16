package com.ablySoft.darklighttheme.utils

import android.view.View


fun View.setSelectedIfDarkTheme() {
    isSelected = DarkTheme.isEnabled(context)
}

fun getIsDarkModeEnabled(): Boolean {
    return PreferenceManager.get().getBoolean(PreferenceManager.PREF_DARK_MODE, defValue = false)
}

