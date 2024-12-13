/*
 * Copyright (C) 2024 FUJIFILM Corporation. All rights reserved.
 *
 * Created on : 09-12-2024
 * Author     : Suhail.CP
 *
 * com.app.breatheasy.utils.base
 *
 * This file contains the implementation of BaseActivity.kt class.
 */
package com.app.breatheasy.utils.base

import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.app.breatheasy.utils.Preference

open class BaseActivity : AppCompatActivity() {


    open val preference by lazy { Preference(this)}

    /**
     * Function that can be used to avoid multi times click on a button/icon
     * @return true if click can be considered,
     *         false if click is very frequent and is to be avoided
     */
    private var lastClicked = 0L
    fun avoidMultipleClick(clickThreshold: Long = 300, action: (() -> Unit)? = null): Boolean {
        return if (SystemClock.elapsedRealtime() - lastClicked < clickThreshold) {
            false
        } else {
            lastClicked = SystemClock.elapsedRealtime()
            action?.invoke()
            true
        }
    }
}
