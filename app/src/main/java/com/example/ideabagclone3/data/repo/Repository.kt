package com.example.ideabagclone3.data.repo

interface Repository<T> {
    fun getItems() : List<T>
    fun getItem(pos: Int) : T
    fun deleteItem(pos: Int)
    fun updateItem(pos: Int, item: T)
    fun appendData(item: T)
    fun Appendmany(items: List<T>)
}