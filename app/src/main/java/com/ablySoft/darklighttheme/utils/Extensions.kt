package com.ablySoft.darklighttheme.utils

import android.content.Context
import android.content.Intent
import android.view.View

fun View.setSelectedIfDarkTheme() {
    isSelected = DarkTheme.isEnabled(context)
//    PreferenceManager.get().save(PreferenceManager.PREF_DARK_MODE, isSelected)
}

fun getIsDarkModeEnabled(): Boolean {
    return PreferenceManager.get().getBoolean(PreferenceManager.PREF_DARK_MODE, defValue = false)
}

fun Context.restartApp(className: Any) {
    val intent = Intent(this, className::class.java)
}

inline fun <reified T : Any> Context.launchActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)