package com.kbkapps.mystockmanager.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.kbkapps.mystockmanager.DatabaseHandler
import com.kbkapps.mystockmanager.R

class ViewStocksFragment : Fragment() {
    lateinit var itemDetails: TextView
    lateinit var itemName: EditText

    companion object {
        fun newInstance() = ViewStocksFragment()
    }

    private lateinit var viewModel: ViewStocksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.view_stocks_fragment, container, false)
        itemDetails = root.findViewById(R.id.textViewItemDetails)
        itemName = root.findViewById(R.id.editTextTextPersonName)
        val btn = root.findViewById<Button>(R.id.button)
        val btn2 = root.findViewById<Button>(R.id.button2)
        val databaseHandler=DatabaseHandler(context,null)
        Log.d("View", "test:$context")
        btn.setOnClickListener {
            val item = databaseHandler.findItem(itemName.text.toString())
            if (item != null) {
                Snackbar.make(it, "${itemName.text} was found", Snackbar.LENGTH_LONG).show()
                itemDetails.text = item.toString()
            } else
                Snackbar.make(it, "${itemName.text} was not found", Snackbar.LENGTH_LONG).show()
        }
        btn2.setOnClickListener {
            val item = databaseHandler.all()
            itemDetails.text = item?.toString()
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewStocksViewModel::class.java)
        // TODO: Use the ViewModel
    }

}