package io.fishingua.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.fishingua.R
import io.fishingua.content.bait.Bait

class BaitRecyclerViewAdapter(private val baits: List<Bait>) :
    RecyclerView.Adapter<BaitRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = baits[position]
        holder.image.setImageResource(item.drawableId)
        holder.name.text = item.name
    }

    override fun getItemCount(): Int = baits.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.card_item_image)
        val name: TextView = view.findViewById(R.id.card_item_name)
    }
}