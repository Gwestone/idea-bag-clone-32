package com.example.ideabagclone3.data.models

open class SectionItem constructor() {
    var Id: Int = 0
        get
        set
    var title: String = "_"
        get
        set
    var itemsCount: Int = 0
        get
        set
    var contentItems : List<ReadItem>? = null
        get
        set

    constructor(Id: Int, title: String, itemsCount: Int) : this() {
        this.Id = Id
        this.title = title
        this.itemsCount = itemsCount
    }
}