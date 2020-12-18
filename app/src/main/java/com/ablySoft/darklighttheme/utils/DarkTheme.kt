package com.ablySoft.darklighttheme.utils

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import com.ablySoft.darklighttheme.R

object DarkTheme {

    fun apply(context: Context, enabled: Boolean = false) {
        var nightMode = 0
        if (enabled) {
            nightMode = AppCompatDelegate.MODE_NIGHT_YES
            context.setTheme(R.style.AppTheme_Dark)
        } else {
            nightMode = AppCompatDelegate.MODE_NIGHT_NO
            context.setTheme(R.style.AppTheme_Light)
        }

        AppCompatDelegate.setDefaultNightMode(nightMode)

        PreferenceManager.get().save(PreferenceManager.PREF_DARK_MODE, enabled)
    }

    fun isEnabled(context: Context): Boolean {
        return context.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK ==
                Configuration.UI_MODE_NIGHT_YES
    }
}