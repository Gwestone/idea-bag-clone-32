package com.example.ideabagclone3.SectionList.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ideabagclone3.data.repo.SectionItemRepo

@Suppress("UNCHECKED_CAST")
class SectionViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SectionViewModel(SectionItemRepo()) as T
    }

}
