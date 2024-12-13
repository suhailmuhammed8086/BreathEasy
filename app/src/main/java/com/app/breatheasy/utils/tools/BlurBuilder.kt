package com.app.breatheasy.utils.tools

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import kotlin.math.roundToInt

class BlurBuilder(context: Context) {
    //region private member
    private val renderScript: RenderScript = RenderScript.create(context)
    private val scriptIntrinsicBlur: ScriptIntrinsicBlur =
        ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))
    //endregion

    //region public method
    /**
     * To create blurred bitmap from a given radius
     * @param bitmapToBeBlurred Bitmap?
     * @param blurRadius Float
     * @return Bitmap?
     */
    fun createBlurredBitmap(bitmapToBeBlurred: Bitmap?, blurRadius: Float): Bitmap? {
        bitmapToBeBlurred?.let {
            val width = (bitmapToBeBlurred.width * BITMAP_SCALE).roundToInt()
            val height = (bitmapToBeBlurred.height * BITMAP_SCALE).roundToInt()
            val inputBitmap = Bitmap.createScaledBitmap(bitmapToBeBlurred, width, height, true)
            val outputBitmap = Bitmap.createBitmap(inputBitmap)
            val tempInAllocation = Allocation.createFromBitmap(renderScript, inputBitmap)
            val tempOutAllocation = Allocation.createFromBitmap(renderScript, outputBitmap)
            scriptIntrinsicBlur.apply {
                setRadius(blurRadius)
                setInput(tempInAllocation)
                forEach(tempOutAllocation)
            }
            tempOutAllocation.copyTo(outputBitmap)
            return outputBitmap
        }
        return null
    }
    //endregion


    //region companion object
    companion object {
        private const val BITMAP_SCALE = 0.4f
        const val MAX_BLUR_RADIUS = 25f
    }
    //endregion
}