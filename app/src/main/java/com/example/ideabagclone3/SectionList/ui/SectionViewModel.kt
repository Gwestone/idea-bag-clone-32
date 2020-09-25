package com.example.ideabagclone3.SectionList.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.ideabagclone3.R
import com.example.ideabagclone3.data.models.SectionItem
import com.example.ideabagclone3.data.repo.SectionItemRepo
import com.example.ideabagclone3.SectionList.SectionListAdapter
import com.example.ideabagclone3.SectionList.SectionListViewHolder
import com.example.ideabagclone3.data.serializable.SectionSerializable
import com.example.ideabagclone3.utils.Constants

class SectionViewModel(private val repo : SectionItemRepo) : ViewModel() {
    public lateinit var ShowListData: MutableLiveData<List<SectionItem>>
    private lateinit var DataList: MutableList<SectionItem>

    public lateinit var sectionListAdapter: SectionListAdapter

    init {
        ShowListData = MutableLiveData<List<SectionItem>>()
        DataList = mutableListOf<SectionItem>()
        updateDataFromRepo()
    }

    fun updateDataFromRepo(){
            DataList = repo.getItems() as MutableList<SectionItem>
            updateAllShowData()
    }

    private fun updateAllShowData(){
        ShowListData.value = this.DataList
    }

    public fun onSectionTabListener(sectionListViewHolder: SectionListViewHolder, view: View?){

        val sectionSerialisable =
            SectionSerializable()
        sectionSerialisable.fromSectionItem(sectionListViewHolder.dataItem)

        val dataPass = Bundle()
        dataPass.putSerializable(Constants.BUNDLE_DATA_PASS_SECTION,sectionSerialisable)

        view?.findNavController()?.navigate(R.id.action_sectionFragment_to_readItemFragment, dataPass)

    }
}