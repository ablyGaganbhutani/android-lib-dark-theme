package com.ablySoft.darklighttheme.utils

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatDelegate

fun getDarkModeValue(): Int {
    return PreferenceManager.get().getInt(PreferenceManager.PREF_DARK_MODE, defValue = 1)
}

fun setSelectedDarkModelValue() {
    when (getDarkModeValue()) {
        AppCompatDelegate.MODE_NIGHT_NO -> {
            DarkTheme.apply(DarkModeEnum.off)
        }
        AppCompatDelegate.MODE_NIGHT_YES -> {
            DarkTheme.apply(DarkModeEnum.on)
        }
        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -> {
            DarkTheme.apply(DarkModeEnum.followSystem)
        }
    }
}

inline fun <reified T : Any> Context.launchActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)