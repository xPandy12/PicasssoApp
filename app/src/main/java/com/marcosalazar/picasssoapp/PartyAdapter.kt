package com.marcosalazar.picasssoapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PartyAdapter(context: Context, parties: IntArray, layout: Int) :
    RecyclerView.Adapter<PartyAdapter.ViewHolder>() {
    private val context: Context
    private val parties: IntArray
    private val layout: Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(parties[position]).fit()
            .placeholder(R.drawable.spinner)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return parties.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView

        init {
            image = itemView.findViewById(R.id.imageViewLayout) as ImageView
        }
    }

    init {
        this.context = context
        this.parties = parties
        this.layout = layout
    }
}
