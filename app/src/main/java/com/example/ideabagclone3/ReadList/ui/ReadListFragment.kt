package com.example.ideabagclone3.ReadList.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.ideabagclone3.R
import com.example.ideabagclone3.ReadList.OnReadListTapListener
import com.example.ideabagclone3.ReadList.RLRecyclerViewAdapter
import com.example.ideabagclone3.ReadList.ReadListViewHolder
import com.example.ideabagclone3.SectionList.ui.SectionViewModel
import com.example.ideabagclone3.SectionList.ui.SectionViewModelFactory
import com.example.ideabagclone3.data.serializable.ReadItemSerializable
import com.example.ideabagclone3.data.serializable.SectionSerializable
import com.example.ideabagclone3.utils.Constants
import kotlinx.android.synthetic.main.fragment_read_item_list.view.*

/**
 * A fragment representing a list of Items.
 */
class ReadListFragment : Fragment(),
    OnReadListTapListener {

    companion object {
        fun newInstance() =
            ReadListFragment()
    }

    private lateinit var viewModel: ReadListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setLocalViewModel()
        val view = inflater.inflate(R.layout.fragment_read_item_list, container, false)

        //get data from arguments bundle
        val dataPass: SectionSerializable = arguments?.getSerializable(Constants.BUNDLE_DATA_PASS_SECTION) as SectionSerializable

        //setup future recycler adapter, get data from bundle
        viewModel.readListRecyclerViewAdapter = RLRecyclerViewAdapter(
            dataPass.contentItems!!,
            this@ReadListFragment
        )

        // Set the adapter
        with(view.read_items_list) {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModel.readListRecyclerViewAdapter
        }

        return view
    }

    override fun onReadItemTapListener(pos: Int, readListViewHolder: ReadListViewHolder) {
        viewModel.onReadItemTapListener(readListViewHolder, view)
    }

    private fun setLocalViewModel(){
        val tempViewModel: ReadListViewModel by viewModels { ReadListViewModelFactory() }
        viewModel = tempViewModel
    }
}