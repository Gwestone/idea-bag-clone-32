package com.example.ideabagclone3.data.repo

import com.example.ideabagclone3.data.FakeDataSource
import com.example.ideabagclone3.data.models.SectionItem

class SectionItemRepo : Repository<SectionItem> {

    private var data: MutableList<SectionItem> = FakeDataSource.createFakeSectionDataList() as MutableList<SectionItem>

    override fun getItems(): List<SectionItem> {
        return data
    }

    override fun getItem(pos: Int): SectionItem {
        return data[pos]
    }

    override fun deleteItem(pos: Int) {
        data.removeAt(pos)
    }

    override fun updateItem(pos: Int, item: SectionItem) {
        data[pos] = item
    }

    override fun appendData(item: SectionItem) {
        data.add(item)
    }

    override fun Appendmany(items: List<SectionItem>) {
        TODO("Not yet implemented")
    }
}
