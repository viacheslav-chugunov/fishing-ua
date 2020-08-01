package io.fishingua.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import io.fishingua.R
import io.fishingua.content.fish.Fish

class FishRecyclerViewAdapter(private val fishes: List<Fish>, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<FishRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = fishes[position]
        holder.image.setImageResource(item.drawableId)
        holder.name.text = item.name
        holder.layout.setOnClickListener { listener(position) }
    }

    override fun getItemCount(): Int = fishes.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layout: LinearLayout = view.findViewById(R.id.card_item_layout)
        val image: ImageView = view.findViewById(R.id.card_item_image)
        val name: TextView = view.findViewById(R.id.card_item_name)
    }
}