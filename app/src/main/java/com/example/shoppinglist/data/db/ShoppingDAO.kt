package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDAO {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query( "SELECT * FROM shopping_items")
    fun getAllshoppingItems(): LiveData<List<ShoppingItem>>
}