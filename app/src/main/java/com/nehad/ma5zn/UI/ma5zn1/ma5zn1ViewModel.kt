package com.nehad.ma5zn.UI.ma5zn1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nehad.ma5zn.Data.entities.Item
import com.nehad.ma5zn.Data.repositories.InventoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class ma5zn1ViewModel: ViewModel() {
    private var liveData:MutableLiveData<List<Item>> = MutableLiveData()
    lateinit var repository: InventoryRepository

    fun upsert(item :Item) = CoroutineScope(Dispatchers.Main).launch { repository.upsert(item) }
    fun delete(item :Item) = CoroutineScope(Dispatchers.Main).launch { repository.delete(item) }
    fun getAllStockItem() = CoroutineScope(Dispatchers.Main).launch { repository.getAllStockItem() }
    fun initLiveData(){
    }
    fun getLiveData():MutableLiveData<List<Item>>{
        return this.liveData
    }
}