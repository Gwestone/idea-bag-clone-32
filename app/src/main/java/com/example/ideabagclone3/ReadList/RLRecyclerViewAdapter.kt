package com.example.ideabagclone3.ReadList

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ideabagclone3.R

import com.example.ideabagclone3.data.models.ReadItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class RLRecyclerViewAdapter(
    private val values: List<ReadItem>,
    private val listener: OnReadListTapListener
) : RecyclerView.Adapter<ReadListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.read_fragment_item, parent, false)
        return ReadListViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ReadListViewHolder, position: Int) {
        val item = values[position]
        holder.ordView.text = position.toString()
        holder.titleView.text = item.title
        holder.difficulttView.text = item.text
        holder.dataItem = item
    }

    override fun getItemCount(): Int = values.size

}