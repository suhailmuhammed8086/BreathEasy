/*
 * Copyright (C) 2024 FUJIFILM Corporation. All rights reserved.
 *
 * Created on : 09-12-2024
 * Author     : Suhail.CP
 *
 * com.app.breatheasy.utils
 *
 * This file contains the implementation of Ext.kt class.
 */
package com.app.breatheasy.utils

import android.content.Intent
import android.os.Build
import android.os.Parcelable
import java.io.Serializable


inline fun <reified T : Serializable> Intent.getSerializableCompact(name: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getSerializableExtra(name, T::class.java)
    } else {
        getSerializableExtra(name) as T?
    }
}

inline fun <reified T : Parcelable> Intent.getParcelableCompact(name: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(name, T::class.java)
    } else {
        getParcelableExtra(name) as T?
    }
}