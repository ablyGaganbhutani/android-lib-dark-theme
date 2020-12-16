package com.ablySoft.darklighttheme.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringDef
import com.google.gson.Gson
import java.util.concurrent.atomic.AtomicBoolean

class PreferenceManager private constructor(context: Context) {
    private val sharedPrefName = "darkMode"
    private val gson = Gson()
    private var preferences: SharedPreferences

    companion object {
        const val PREF_DARK_MODE = "PREF_DARK_MODE"

        @StringDef(PREF_DARK_MODE)
        @Retention(AnnotationRetention.SOURCE)
        annotation class PrefKey

        private lateinit var instance: PreferenceManager
        private val isInitialized =
            AtomicBoolean()     // To check if instance was previously initialized or not

        fun initialize(context: Context) {
            if (!isInitialized.getAndSet(true)) {
                instance = PreferenceManager(context.applicationContext)
            }
        }

        fun get(): PreferenceManager = instance
    }

    init {
        preferences = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
    }

    fun save(@PrefKey key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(@PrefKey key: String, defValue: Boolean): Boolean =
        preferences.getBoolean(key, defValue)

    fun <T> getObject(@PrefKey key: String, objectClass: Class<T>): T? {
        val jsonString = preferences.getString(key, null)
        return if (jsonString == null) {
            null
        } else {
            try {
                gson.fromJson(jsonString, objectClass)
            } catch (e: Exception) {
                throw IllegalArgumentException("Object stored with key $key is instance of other class")
            }
        }
    }

    fun removeAll() {
        preferences.edit().clear().apply()
    }

}