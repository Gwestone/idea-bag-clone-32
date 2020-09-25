package com.example.ideabagclone3.ReadList.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.ideabagclone3.R
import com.example.ideabagclone3.ReadList.RLRecyclerViewAdapter
import com.example.ideabagclone3.ReadList.ReadListViewHolder
import com.example.ideabagclone3.data.models.ReadItem
import com.example.ideabagclone3.data.serializable.ReadItemSerializable
import com.example.ideabagclone3.utils.Constants

class ReadListViewModel : ViewModel() {

    public lateinit var ShowListData: MutableLiveData<List<ReadItem>>
    private lateinit var DataList: MutableList<ReadItem>

    public lateinit var readListRecyclerViewAdapter: RLRecyclerViewAdapter

    public fun onReadItemTapListener(readListViewHolder: ReadListViewHolder, view: View?){

        val readItemSerialisable =
            ReadItemSerializable()
        readItemSerialisable.fromReadItem(readListViewHolder.dataItem)

        val dataPass = Bundle()
        dataPass.putSerializable(Constants.BUNDLE_DATA_PASS_READ,readItemSerialisable)

        view?.findNavController()?.navigate(R.id.action_readItemFragment_to_readFragment, dataPass)
    }
}