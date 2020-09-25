package com.example.ideabagclone3.data.repo

import com.example.ideabagclone3.data.FakeDataSource
import com.example.ideabagclone3.data.models.ReadItem

class ReadItemRepo() : Repository<ReadItem>{

    private var data: MutableList<ReadItem> = FakeDataSource.createFakeReadDataList() as MutableList<ReadItem>

    override fun getItems(): List<ReadItem> {
        return data
    }

    override fun getItem(pos: Int): ReadItem {
        return data[pos]
    }

    override fun deleteItem(pos: Int) {
        data.removeAt(pos)
    }

    override fun updateItem(pos: Int, item: ReadItem) {
        data[pos] = item
    }

    override fun appendData(item: ReadItem) {
        data.add(item)
    }

    override fun Appendmany(items: List<ReadItem>) {
        TODO("Not yet implemented")
    }
}