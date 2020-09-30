package com.nehad.ma5zn.UI.ma5zn1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nehad.ma5zn.Data.db.InventoryDatabase
import com.nehad.ma5zn.Data.entities.Item
import com.nehad.ma5zn.Data.repositories.InventoryRepository
import com.nehad.ma5zn.UI.AddDialogListener
import com.nehad.ma5zn.UI.AddItemDialog
import kotlinx.android.synthetic.main.ma5zn.*


class Ma5znFragment  : Fragment() {
    lateinit var ma5zn1ViewModel: ma5zn1ViewModel
    var testArrayList = ArrayList<String>()


      private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        viewManager = LinearLayoutManager(activity)
//        viewAdapter = MyAdapter(myDataset)
//
//
//        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
//            // use this setting to improve performance if you know that changes
//            // in content do not change the layout size of the RecyclerView
//            setHasFixedSize(true)
//
//            // use a linear layout manager
//            layoutManager = viewManager
//
//            // specify an viewAdapter (see also next example)
//            adapter = viewAdapter





            testArrayList.add("Test Item1")
        testArrayList.add("Test Item2")
        testArrayList.add("Test Item3")
        testArrayList.add("Test Item4")


        val database = InventoryDatabase(activity!!.applicationContext)
        //val database = InventoryDatabase(context!!.applicationContext)


        ma5zn1_recyclerView.layoutManager = LinearLayoutManager(activity)

        val repository = InventoryRepository(database)
        ma5zn1ViewModel = ViewModelProviders.of(this).get(ma5zn1ViewModel::class.java)
        ma5zn1ViewModel.initLiveData()
        val adapter:ma5zn1Adapter= ma5zn1Adapter()


        ma5zn1ViewModel.getLiveData().observe(this, Observer {
            adapter.itemsList = it as ArrayList<Item>
            adapter.notifyDataSetChanged()
            // ma5zn1Adapter.setList(it)
        })
        //
       // ma5zn1_recyclerView.layoutManager = LinearLayoutManager(activity)
     //   ma5zn1_recyclerView.adapter =adapter
/*
        viewModel.getAllStockItem().(this ,  Observer{
            /*adapter.itemsList = it
            adapter.notifyDataSetChanged()*/
        })*/
        fab1.setOnClickListener {
            AddItemDialog(activity!!.applicationContext, object : AddDialogListener {
                override fun onAddButtonClicked(item: Item) {
                    ma5zn1ViewModel.upsert(item)
                }
            }).show()
        }
    }





    }
