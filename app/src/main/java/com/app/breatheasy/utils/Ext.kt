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

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import android.os.Parcelable
import android.view.View
import com.app.breatheasy.utils.tools.BlurBuilder
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


fun Activity.getBlurredImageOfActivity(rootView: View, blur: Float = 7f): Bitmap? {
    val bitmap = Bitmap.createBitmap(
        rootView.width,
        rootView.height,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    rootView.draw(canvas)
    val blurBuilder = BlurBuilder(this)
    val blurredBitmap = blurBuilder.createBlurredBitmap(bitmap, blur)
    return blurredBitmap
}