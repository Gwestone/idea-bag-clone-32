package com.example.ideabagclone3.data.models

open class ReadItem constructor() {
    var Id: Int = 0
        get
        set
    var title: String = ""
        get
        set
    var text: String = ""
        get
        set
    var difficultLevels: DifficultLevels = DifficultLevels.Baggier
        get
        set

    constructor(Id: Int, title: String, text: String, difficultLevels: DifficultLevels) : this() {
        this.Id = Id
        this.title = title
        this.text = text
        this.difficultLevels = difficultLevels
    }
}