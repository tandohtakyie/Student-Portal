package com.example.studentportal

import androidx.recyclerview.widget.RecyclerView
import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup

class RecyclerAdapter(val items : ArrayList<StudentPortal>, val context: Context, val listener: (Int) -> Unit ) : RecyclerView.Adapter<LinkViewHolder>()  {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LinkViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val cellForRow = layoutInflater.inflate(R.layout.link_view_main, p0, false)

        return LinkViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int ) {
        holder.bind(items[position], position, listener)
    }


}