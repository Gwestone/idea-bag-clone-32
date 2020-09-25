package com.example.ideabagclone3.utils

interface Callback<T>{
    fun onResult(data: T)
    fun onError(err: Throwable)
}
