package com.example.ideabagclone3.SectionList.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ideabagclone3.R
import com.example.ideabagclone3.data.FakeDataSource
import com.example.ideabagclone3.SectionList.OnSectionTapListener
import com.example.ideabagclone3.SectionList.SectionListAdapter
import com.example.ideabagclone3.SectionList.SectionListViewHolder
import kotlinx.android.synthetic.main.section_list_fragment.view.*

class SectionListFragment : Fragment(),
    OnSectionTapListener {

    companion object {
        fun newInstance() =
            SectionListFragment()
    }

    private lateinit var viewModel: SectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        conigureFragment()
        setLocalViewModel()

        val view = inflater.inflate(R.layout.section_list_fragment, container, false)
        //val dataBind: SectionFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.section_list_fragment, container, false)
        //val view = dataBind.root

        viewModel.sectionListAdapter = SectionListAdapter(
            FakeDataSource.createFakeSectionDataList(),
            this@SectionListFragment
        )

        // Set the adapter
        with(view.section_list) {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModel.sectionListAdapter
        }

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.ShowListData.observe(viewLifecycleOwner, Observer {
            viewModel.sectionListAdapter.notifyDataSetChanged()
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_notes -> {
                return true
            }
            R.id.menu_add_item -> {
                 return true
            }
            else -> return false
        }
    }

    private fun conigureFragment(){
        setHasOptionsMenu(true)
        //other configurtions
    }

    private fun setLocalViewModel(){
        val tempViewModel: SectionViewModel by viewModels { SectionViewModelFactory() }
        viewModel = tempViewModel
    }

    override fun onSectionTapListener(pos: Int, sectionListViewHolder: SectionListViewHolder) {
        viewModel.onSectionTabListener(sectionListViewHolder, view)
    }

    override fun onCreateOptionsMenu(menu: Menu,inflater: MenuInflater) {
        inflater.inflate(R.menu.section_list_menu, menu)
        super.onCreateOptionsMenu(menu,inflater)
    }

}