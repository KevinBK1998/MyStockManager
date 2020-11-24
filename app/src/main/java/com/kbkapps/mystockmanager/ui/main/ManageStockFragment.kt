package com.kbkapps.mystockmanager.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.kbkapps.mystockmanager.DatabaseHandler
import com.kbkapps.mystockmanager.Item
import com.kbkapps.mystockmanager.R

class ManageStockFragment : Fragment() {
    lateinit var itemName: EditText
    lateinit var itemDescription: EditText
    lateinit var itemPrice: EditText
    lateinit var itemQuantity: EditText

    companion object {
        fun newInstance() = ManageStockFragment()
    }

    private lateinit var viewModelManage: ManageStockViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.manage_stock_fragment, container, false)
        itemName = root.findViewById(R.id.itemName)
        itemPrice = root.findViewById(R.id.itemPrice)
        itemDescription = root.findViewById(R.id.itemDescription)
        itemQuantity = root.findViewById(R.id.itemQuantity)
        val btn = root.findViewById<Button>(R.id.addButton)
        val databaseHandler=DatabaseHandler(context,null,null,1)
        btn.setOnClickListener { view ->
            val item= Item(
                itemName.text.toString(),
                itemDescription.text.toString(),
                itemPrice.text.toString().toFloat(),
                itemQuantity.text.toString().toInt(),
            )
            databaseHandler.addItems(item)
            Snackbar.make(view, "${itemName.text} was added", Snackbar.LENGTH_LONG)
                .setAction("Undo", null).show()
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelManage = ViewModelProviders.of(this).get(ManageStockViewModel::class.java)
        // TODO: Use the ViewModel
    }

}