package com.nehad.ma5zn.UI

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.nehad.ma5zn.Data.entities.Item
import com.nehad.ma5zn.R
import kotlinx.android.synthetic.main.add_item_dialog.*
import kotlinx.android.synthetic.main.item.*

class AddItemDialog(context: Context , var addDialogListener: AddDialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_dialog)
        tvAdd.setOnClickListener {
            val  code = tvCode.text.toString()
            val  qty = tvAmount.text.toString()

            if(code.isEmpty() || qty.isEmpty()){
                Toast.makeText(context, "please Enter all the information ", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val additem = Item(code , qty.toInt())
            addDialogListener.onAddButtonClicked(additem)
            dismiss()

        }
        tvCancel.setOnClickListener { cancel() }
    }
}