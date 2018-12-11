package gsihome.reyst.exhibition.gui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import gsihome.reyst.exhibition.R
import gsihome.reyst.exhibition.util.ImageLoader
import gsihome.reyst.model.entity.Exhibit

class ExhibitAdapter(
        private val imageLoader: ImageLoader
) : RecyclerView.Adapter<ExhibitViewHolder>() {

    private var items: List<Exhibit> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ExhibitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.exhibit_item, parent, false)
        return ExhibitViewHolder(itemView, imageLoader)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ExhibitViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(data: List<Exhibit>) {
        items = data
        notifyDataSetChanged()
    }
}