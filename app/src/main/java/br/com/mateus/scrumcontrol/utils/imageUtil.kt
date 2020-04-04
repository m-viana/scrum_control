package br.com.mateus.scrumcontrol.utils
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import android.view.View
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import java.io.ByteArrayOutputStream
import java.io.IOException

class ImageUtil {
    var context: Context? = null
    var width = 400

    constructor(context: Context?) {
        this.context = context
    }

    fun getBitmapFromUri(uri: Uri?): Bitmap? {
        return try {
            val bitmap =
                MediaStore.Images.Media.getBitmap(context!!.contentResolver, uri)
            resizeBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun getBitmapFromBase64(base64: String?): Bitmap? {
        val decodedString =
            Base64.decode(base64, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    }

    fun getBase64FromBitmap(bitmap: Bitmap): String? {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    fun getCircleDrawnable(bitmap: Bitmap): Drawable? {
        val dr =
            RoundedBitmapDrawableFactory.create(context!!.resources, bitmap)
        dr.cornerRadius = bitmap.width.toFloat()
        return dr
    }

    fun resizeBitmap(bitmap: Bitmap): Bitmap? {
        return if (bitmap.height < width) {
            bitmap
        } else {
            Bitmap.createScaledBitmap(bitmap, width, width, false)
        }
    }

    fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int): Bitmap? {
        return if (bitmap.height < width) {
            bitmap
        } else {
            Bitmap.createScaledBitmap(bitmap, width, height, false)
        }
    }

    fun resizeBitmap(bitmap: Bitmap, scale: Float): Bitmap? {
        return Bitmap.createScaledBitmap(
            bitmap,
            (bitmap.width * scale).toInt(),
            (bitmap.height * scale).toInt(),
            false
        )
    }

    fun getDrawableFromBitmap(bitmap: Bitmap?): Drawable? {
        return BitmapDrawable(context!!.resources, bitmap)
    }

    fun setDrawnableColor(
        drawable: Drawable,
        color: Int
    ): Drawable? {
        drawable.setColorFilter(context!!.resources.getColor(color), PorterDuff.Mode.SRC_ATOP)
        return drawable
    }

    fun getBitmapFromDrawable(drawable: Drawable): Bitmap? {
        var bitmap: Bitmap? = null
        if (drawable is BitmapDrawable) {
            val bitmapDrawable = drawable
            if (bitmapDrawable.bitmap != null) {
                return bitmapDrawable.bitmap
            }
        }
        bitmap = if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            Bitmap.createBitmap(
                1,
                1,
                Bitmap.Config.ARGB_8888
            ) // Single color bitmap will be created of 1x1 pixel
        } else {
            Bitmap.createBitmap(
                drawable.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
        }
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun takescreenshotOfRootView(v: View): Bitmap? {
        var v = v
        v = v.rootView
        v.isDrawingCacheEnabled = true
        v.buildDrawingCache(true)
        val bitmap = Bitmap.createBitmap(v.drawingCache)
        v.isDrawingCacheEnabled = false
        return bitmap
    }
}
