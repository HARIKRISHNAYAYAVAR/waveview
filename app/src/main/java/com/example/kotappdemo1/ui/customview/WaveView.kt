package com.example.kotappdemo1.ui.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class WaveView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.CYAN // Default color, you can customize
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()

        // Calculate control points for the curves
        val curveControlX = width / 2
        val curveControlY1 = height / 4
        val curveControlY2 = height * 3 / 4

        val path = Path().apply {
            moveTo(0f, height / 2)
            cubicTo(curveControlX, curveControlY1, curveControlX, curveControlY2, width, height / 2)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }

        canvas.drawPath(path, paint)
    }
}