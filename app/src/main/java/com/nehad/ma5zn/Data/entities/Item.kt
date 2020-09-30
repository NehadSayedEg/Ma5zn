package com.nehad.ma5zn.Data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
     @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name ="code")
    var code : String ,

    @ColumnInfo(name ="qty")
    var qty :Int )
