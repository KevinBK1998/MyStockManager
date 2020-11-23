package com.kbkapps.mystockmanager.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.kbkapps.mystockmanager.R

class ManageStockFragment : Fragment() {

    companion object {
        fun newInstance() = ManageStockFragment()
    }

    private lateinit var viewModelManage: ManageStockViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manage_stock_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelManage = ViewModelProviders.of(this).get(ManageStockViewModel::class.java)
        // TODO: Use the ViewModel
    }

}