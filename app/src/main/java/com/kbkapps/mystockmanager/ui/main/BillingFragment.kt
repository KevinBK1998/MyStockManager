package com.kbkapps.mystockmanager.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.kbkapps.mystockmanager.R

class BillingFragment : Fragment() {

    companion object {
        fun newInstance() = BillingFragment()
    }

    private lateinit var viewModel: BillingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.billing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BillingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}