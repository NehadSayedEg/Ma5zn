package com.nehad.ma5zn.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nehad.ma5zn.Data.entities.Item

@Dao
interface InventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(item: Item)

    @Delete
   suspend fun delete(item: Item)

    @Query( "SELECT * FROM  item_table")
    fun getAllItem() : LiveData <List<Item>>

}