package com.example.studentportal


import androidx.recyclerview.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.link_view_main.view.*

class LinkViewHolder (val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: StudentPortal, pos: Int,listener: (Int) -> Unit) = with(itemView) {

        view.linkLabel.text = "  " + item.name + "  "
        view.setOnClickListener {
            listener(item.id)
        }
    }

}