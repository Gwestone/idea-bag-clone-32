package com.example.ideabagclone3.ReadItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ideabagclone3.R
import com.example.ideabagclone3.data.serializable.ReadItemSerializable
import com.example.ideabagclone3.utils.Constants
import kotlinx.android.synthetic.main.read_fragment.view.*

class ReadItemFragment : Fragment() {

    companion object {
        fun newInstance() = ReadItemFragment()
    }

    private lateinit var readItemViewModel: ReadItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.read_fragment, container, false)

        val dataPass: ReadItemSerializable = arguments?.getSerializable(Constants.BUNDLE_DATA_PASS_SECTION) as ReadItemSerializable

        view.read_title.text = dataPass.title
        view.read_text.text = dataPass.text
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val itemViewModel: ReadItemViewModel by viewModels<ReadItemViewModel>{ ReadItemViewModelFactory() }
        readItemViewModel = itemViewModel

    }

}