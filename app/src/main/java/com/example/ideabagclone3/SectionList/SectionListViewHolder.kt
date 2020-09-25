package com.example.ideabagclone3.SectionList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ideabagclone3.R
import com.example.ideabagclone3.data.models.SectionItem
import com.example.ideabagclone3.SectionList.ui.SectionListFragment

class SectionListViewHolder(
    view: View,
    private val sectionListFragment: SectionListFragment
) : RecyclerView.ViewHolder(view), View.OnClickListener {
    val titleView: TextView = view.findViewById(R.id.item_title)
    val countView: TextView = view.findViewById(R.id.item_difficult)

    public var currentView: View? = null
    public var pos: Int? = null
    public lateinit var dataItem: SectionItem

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        currentView = v
        pos = adapterPosition
        sectionListFragment.onSectionTapListener(adapterPosition, this)
    }

}