package com.ablySoft.darklighttheme.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import com.ablySoft.darklighttheme.R

object DarkTheme {

    fun apply(enum: DarkModeEnum) {
        val nightMode =  when(enum){
            DarkModeEnum.off -> {
                AppCompatDelegate.MODE_NIGHT_NO
            }
            DarkModeEnum.on -> {
                AppCompatDelegate.MODE_NIGHT_YES
            }
            DarkModeEnum.followSystem -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    (AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                } else {
                    (AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
                }
            }
        }

        AppCompatDelegate.setDefaultNightMode(nightMode)
        PreferenceManager.get().save(PreferenceManager.PREF_DARK_MODE, nightMode)
    }

    fun Context.isEnabled(): Boolean {
        return this.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK ==
                Configuration.UI_MODE_NIGHT_YES
    }
}