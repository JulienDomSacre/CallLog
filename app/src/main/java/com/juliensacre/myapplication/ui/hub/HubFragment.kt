package com.juliensacre.myapplication.ui.hub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.juliensacre.myapplication.R

class HubFragment : Fragment() {

    companion object {
        fun newInstance() = HubFragment()
    }

    private lateinit var viewModel: HubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.call_log_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HubViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
