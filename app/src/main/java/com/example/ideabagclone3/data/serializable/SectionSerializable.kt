package com.example.ideabagclone3.data.serializable

import com.example.ideabagclone3.data.models.ReadItem
import com.example.ideabagclone3.data.models.SectionItem
import java.io.Serializable

class SectionSerializable : Serializable, SectionItem() {
    fun fromSectionItem(sectionItem: SectionItem){
        this.Id = sectionItem.Id
        this.contentItems = sectionItem.contentItems
        this.itemsCount = sectionItem.itemsCount
        this.title = sectionItem.title
    }
}