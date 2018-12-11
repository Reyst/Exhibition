package gsihome.reyst.exhibition.gui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import gsihome.reyst.exhibition.R
import gsihome.reyst.exhibition.util.ImageLoader
import gsihome.reyst.model.entity.Exhibit

class ExhibitViewHolder(itemView: View, private val imageLoader: ImageLoader) : RecyclerView.ViewHolder(itemView) {

    private val container: ViewGroup = itemView.findViewById(R.id.image_container)

    private val mapLocationToViews: MutableMap<String, Pair<TextView, ImageView>> = HashMap()
    private val inflater = LayoutInflater.from(itemView.context)

    fun bind(item: Exhibit) {
        item.images.forEach { imageLocation ->
            val (title, image) = getViews(imageLocation)
            title.text = item.title
            imageLoader.loadImageInto(image, imageLocation)
        }

    }

    private fun getViews(imageLocation: String): Pair<TextView, ImageView> {
        val pairOfView = mapLocationToViews[imageLocation]

        return if (pairOfView != null) pairOfView
        else {
            val view = inflater.inflate(R.layout.item_image, container, false)
            container.addView(view)
            container.invalidate()
            val pair = Pair<TextView, ImageView>(view.findViewById(R.id.tv_title), view.findViewById(R.id.image))
            mapLocationToViews[imageLocation] = pair
            pair
        }
    }

}
