package com.example.ideabagclone3.ReadList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ideabagclone3.R
import com.example.ideabagclone3.data.models.ReadItem

class ReadListViewHolder(view: View, listener: OnReadListTapListener) : RecyclerView.ViewHolder(view), View.OnClickListener{

    var mListener: OnReadListTapListener = listener

    val titleView: TextView = view.findViewById(R.id.item_title)
    val difficulttView: TextView = view.findViewById(R.id.item_difficult)
    val ordView: TextView = view.findViewById(R.id.item_ordinal)

    public lateinit var dataItem: ReadItem

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        this.mListener.onReadItemTapListener(adapterPosition, this)
    }

}