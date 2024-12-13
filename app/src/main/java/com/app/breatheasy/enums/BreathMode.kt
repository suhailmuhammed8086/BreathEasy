/*
 * Copyright (C) 2024 FUJIFILM Corporation. All rights reserved.
 *
 * Created on : 09-12-2024
 * Author     : Suhail.CP
 *
 * com.app.breatheasy.enums
 *
 * This file contains the implementation of BreathMode.kt class.
 */
package com.app.breatheasy.enums

import com.app.breatheasy.R

enum class BreathMode {
    DIAPHRAGMATIC_BREATHING,
    BOX_BREATHING,
    FOUR_7_8_BREATHING,
    ALTERNATE_NOSTRIL_BREATHING;


    fun getImageRes(): Int {
        return when (this) {
            DIAPHRAGMATIC_BREATHING -> R.drawable.img_one
            BOX_BREATHING -> R.drawable.img_four
            FOUR_7_8_BREATHING -> R.drawable.img_five
            ALTERNATE_NOSTRIL_BREATHING -> R.drawable.img_two
        }
    }

    fun getTitle(): String {
        return when (this) {
            DIAPHRAGMATIC_BREATHING -> "Diaphragmatic Breathing"
            BOX_BREATHING -> "Box Breathing"
            FOUR_7_8_BREATHING -> "4-7-8 Breathing"
            ALTERNATE_NOSTRIL_BREATHING -> "Alternate Nostril Breathing"
        }
    }

    fun getDescription(): String {
        return when (this) {
            DIAPHRAGMATIC_BREATHING -> "A deep breathing technique that focuses on expanding your diaphragm, promoting full oxygen exchange and relaxation."
            BOX_BREATHING -> "A rhythmic breathing technique involving equal inhale, hold, exhale, and rest durations. Often used to enhance focus and calm the mind."
            FOUR_7_8_BREATHING -> "A breathing technique that involves inhaling for 4 seconds, holding the breath for 7 seconds, and exhaling slowly for 8 seconds."
            ALTERNATE_NOSTRIL_BREATHING -> "A yoga-based breathing technique where you alternate breathing through each nostril. It balances your nervous system and harmonizes energy flow."
        }
    }

    fun getBenefits(): List<String> {
        return when (this) {
            DIAPHRAGMATIC_BREATHING -> listOf(
                "Reduces stress and anxiety.",
                "Improves oxygen delivery to your body.",
                "Lowers blood pressure.",
                "Strengthens the diaphragm muscle."
            )

            BOX_BREATHING -> listOf(
                "Boosts focus and mental clarity.",
                "Reduces stress by slowing the heart rate.",
                "Improves lung capacity over time.",
                "Promotes relaxation in high-stress situations.",
            )

            FOUR_7_8_BREATHING -> listOf(
                "Helps you fall asleep faster.",
                "Reduces anxiety and promotes calmness.",
                "Improves heart rate variability and oxygen flow.",
                "Trains your body for slower, deeper breathing.",
            )

            ALTERNATE_NOSTRIL_BREATHING -> listOf(
                "Enhances mental clarity and concentration.",
                "Balances the left and right brain hemispheres.",
                "Reduces stress and promotes relaxation.",
                "Improves lung function.",
            )
        }
    }
}

