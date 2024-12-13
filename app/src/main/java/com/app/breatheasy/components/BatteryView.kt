package com.app.breatheasy.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlin.math.roundToInt

class BatteryView : View {

    companion object {
        private const val MAXIMUM_BARS = 6
        private const val INNER_PADDING_PERCENTAGE = 0.05
        private const val LAST_BAR_HEIGHT_PERCENTAGE = 0.50f
    }

    var batteryPercentage = 50
        set(value) {
            field = value
            invalidate()
        }

    private val batteryBarPaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        val innerPadding = (width * INNER_PADDING_PERCENTAGE).roundToInt()
        val barCount = ((MAXIMUM_BARS / 100f) * batteryPercentage.toFloat()).roundToInt()
        val totalInnerPadding = (MAXIMUM_BARS + 1) * innerPadding
        val batteryBarWidth = ((width - totalInnerPadding) / MAXIMUM_BARS.toFloat()).roundToInt()
        val radius = batteryBarWidth * 0.4f
        val barHeight = height - (innerPadding * 2)
        canvas.translate(innerPadding.toFloat(), 0f)
        for (i in 0..<MAXIMUM_BARS) {
            val startX = (i * batteryBarWidth) + (innerPadding * i)
            var startY = innerPadding
            var wheight = barHeight

            if (i == MAXIMUM_BARS - 1) {
                wheight = (barHeight * LAST_BAR_HEIGHT_PERCENTAGE).roundToInt()
                startY = (height - wheight) / 2
            }
            val rect = RectF(
                startX.toFloat(),
                startY.toFloat(),
                (startX + batteryBarWidth).toFloat(),
                (startY + wheight).toFloat()
            )

            if (i > barCount - 1) {
                batteryBarPaint.alpha = 100
            } else {
                batteryBarPaint.alpha = 255
            }

            canvas.drawRoundRect(rect, radius, radius, batteryBarPaint, )
        }

        super.onDraw(canvas)
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int,
    ) : super(context, attrs, defStyleAttr, defStyleRes)
}