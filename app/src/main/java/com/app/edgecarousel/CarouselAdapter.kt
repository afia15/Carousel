package com.app.edgecarousel

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.carousel.MaskableFrameLayout


class CarouselAdapter(
    var items: List<Banner>,
    private val onItemClick: (Banner) -> Unit
) : RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val banner = items.get(position)
        val imageView = holder.itemView.findViewById<ImageView>(R.id.carousel_image_view)

        imageView.load(banner.imageUrl) {
            crossfade(true)
        }
        imageView.setOnClickListener { onItemClick(banner) }

        val carousel_title = holder.itemView.findViewById<TextView>(R.id.carousel_title)
        carousel_title.text = banner.title

        val carousel_description = holder.itemView.findViewById<TextView>(R.id.carousel_description)
        carousel_description.text = banner.description

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    //Replace Data List
    @SuppressLint("NotifyDataSetChanged")
    fun replaceDate(newList: List<Banner>) {
        items = newList
        notifyDataSetChanged()
    }


}