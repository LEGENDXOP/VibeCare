package com.teamx.vibecare.auth.utils

import android.content.Context
import androidx.core.content.edit

object TokenStorage {
    private const val PREFS = "auth_prefs"
    private const val KEY_ACCESS = "access_token"
    private const val KEY_REFRESH = "refresh_token"

    fun saveTokens(context: Context, access: String, refresh: String) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prefs.edit {
            putString(KEY_ACCESS, access)
                .putString(KEY_REFRESH, refresh)
        }
    }

    fun getAccess(context: Context): String? =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getString(KEY_ACCESS, null)

    fun getRefresh(context: Context): String? =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getString(KEY_REFRESH, null)
}