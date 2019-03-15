package com.juliensacre.myapplication.ui.calldetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.juliensacre.myapplication.R

class CallDetailFragment : Fragment() {

    companion object {
        fun newInstance() = CallDetailFragment()
    }

    private lateinit var viewModel: CallDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_call_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CallDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
