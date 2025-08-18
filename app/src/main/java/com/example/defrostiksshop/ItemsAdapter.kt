package com.example.defrostiksshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.title.text = items[position].title
        holder.desc.text = items[position].desc
        holder.price.text = items[position].price.toString() + "$"

        val imageId = context.resources.getIdentifier(items[position].image, "drawable", context.packageName)

        holder.image.setImageResource(imageId)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.itemListImage)
        val title = view.findViewById<TextView>(R.id.itemListTitle)
        val desc = view.findViewById<TextView>(R.id.itemListDesc)
        val price = view.findViewById<TextView>(R.id.itemListPrice)
    }

}