package com.nehad.ma5zn.Data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nehad.ma5zn.Data.entities.Item
import com.nehad.ma5zn.UI.ma5zn1.Ma5znFragment
import com.nehad.ma5zn.db.InventoryDao

@Database(entities = [Item::class], version = 1)
 abstract class InventoryDatabase : RoomDatabase() {

    abstract fun  getInventoryDao(): InventoryDao
    companion object{
        @Volatile
        private var instance : InventoryDatabase? = null
        private val LOCK = Any()

    operator fun invoke(context: Context) = instance
        ?: synchronized(LOCK) {
            instance
                ?: createDatabase(
                    context
                ).also { instance = it }
        }

    private fun createDatabase(context: Context) =
        Room.databaseBuilder(context.applicationContext,
            InventoryDatabase::class.java, "InventoryDB.db").build()
}
}