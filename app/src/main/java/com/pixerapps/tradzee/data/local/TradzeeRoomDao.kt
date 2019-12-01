package com.pixerapps.tradzee.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pixerapps.tradzee.model.Order


@Dao
interface TradzeeRoomDao {

    //queries for orders
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrder(order: Order)

    @Query("SELECT * FROM orders ORDER BY createdAt")
    fun getOrders(): List<Order>
}