package gsihome.reyst.exhibition.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicassoImageLoader : ImageLoader {

    private val picasso = Picasso.get()

    override fun loadImageInto(view: ImageView, location: String) {
        picasso.load(location)

                .into(view)
    }
}