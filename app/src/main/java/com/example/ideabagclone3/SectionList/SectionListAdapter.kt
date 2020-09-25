package com.example.ideabagclone3.SectionList

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ideabagclone3.R

import com.example.ideabagclone3.data.models.SectionItem
import com.example.ideabagclone3.SectionList.ui.SectionListFragment

/**
 * TODO: Replace the implementation with code for your data type.
 */
class SectionListAdapter(
    private val values: List<SectionItem>,
    private val sectionListFragment: SectionListFragment
)
    : RecyclerView.Adapter<SectionListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionListViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.section_item, parent, false)
        return SectionListViewHolder(view, sectionListFragment)
    }

    override fun onBindViewHolder(holderSectionList: SectionListViewHolder, position: Int) {
        val item = values[position]
        holderSectionList.titleView.text = item.title
        holderSectionList.countView.text = item.itemsCount.toString()
        holderSectionList.dataItem = item
    }

    override fun getItemCount(): Int = values.size
}
