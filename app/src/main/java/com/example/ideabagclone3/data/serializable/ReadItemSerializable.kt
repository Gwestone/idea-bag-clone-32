package com.example.ideabagclone3.data.serializable

import com.example.ideabagclone3.data.models.ReadItem
import com.example.ideabagclone3.data.models.SectionItem
import java.io.Serializable

class ReadItemSerializable : Serializable, ReadItem() {
    fun fromReadItem(readItem: ReadItem){
        this.Id = readItem.Id
        this.difficultLevels = readItem.difficultLevels
        this.text = readItem.text
        this.title = readItem.title
    }
}