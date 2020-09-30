package com.nehad.ma5zn.Data.repositories

import com.nehad.ma5zn.Data.db.InventoryDatabase
import com.nehad.ma5zn.Data.entities.Item

class InventoryRepository(private val db: InventoryDatabase
     ){
    suspend fun upsert(item: Item) = db.getInventoryDao().upsert(item)
    suspend fun delete(item: Item) = db.getInventoryDao().delete(item)

    fun getAllStockItem() = db.getInventoryDao().getAllItem()


}
