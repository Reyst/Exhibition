package gsihome.reyst.exhibition.util

import android.widget.ImageView

interface ImageLoader {
    fun loadImageInto(view: ImageView, location: String)
}