/*
 * Copyright (C) 2024 FUJIFILM Corporation. All rights reserved.
 *
 * Created on : 13-12-2024
 * Author     : Suhail.CP
 *
 * com.app.breatheasy.utils
 *
 * This file contains the implementation of Preference.kt class.
 */
package com.app.breatheasy.utils

import android.content.Context
import com.app.breatheasy.enums.BreathMode

class Preference(private val context: Context) {

    companion object {
        private const val SHARED_PREF_NAME = "BreathEasyPref"


        private const val IS_INFO_SHOWN = "_IS_INFO_SHOWN"
    }

    private val sharedPreference = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    fun isModeInfoShown(mode: BreathMode): Boolean {
        val key = mode.name.plus(IS_INFO_SHOWN)
        val isShown =  sharedPreference.getBoolean(key, false)
        return isShown
    }
    fun setIsModeInfoShown(mode: BreathMode) {
        val key = mode.name.plus(IS_INFO_SHOWN)
        val editor = sharedPreference.edit()
        editor.putBoolean(key, true)
        editor.apply()
    }
}