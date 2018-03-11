package sk.styk.martin.apkanalyzer.util.file

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

/**
 * @author Martin Styk {@literal <martin.styk@gmail.com>}
 */
fun Drawable.toBitmap(): Bitmap? {
    var bitmap: Bitmap? = null

    if (this is BitmapDrawable) {
        val bitmapDrawable = this
        if (bitmapDrawable.bitmap != null) {
            return bitmapDrawable.bitmap
        }
    }

    if (this.intrinsicWidth <= 0 || this.intrinsicHeight <= 0) {
        bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) // Single color bitmap will be created of 1x1 pixel
    } else {
        bitmap = Bitmap.createBitmap(this.intrinsicWidth, this.intrinsicHeight, Bitmap.Config.ARGB_8888)
    }

    val canvas = Canvas(bitmap)
    this.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
    this.draw(canvas)
    return bitmap
}
