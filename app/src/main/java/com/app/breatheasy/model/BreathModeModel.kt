/*
 * Copyright (C) 2024 FUJIFILM Corporation. All rights reserved.
 *
 * Created on : 09-12-2024
 * Author     : Suhail.CP
 *
 * com.app.breatheasy.model
 *
 * This file contains the implementation of BreathModeModel.kt class.
 */
package com.app.breatheasy.model

import com.app.breatheasy.enums.BreathMode

data class BreathModeModel(
    val type: BreathMode,
    val name: String,
    val description: String,
    val imageRes: Int,
) {
}