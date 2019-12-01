package com.pixerapps.tradzee.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MarketWatch(
    @SerializedName("stocks") val stocks: List<Stocks>
)


class Stocks : Serializable {
    @SerializedName("id")
    var id = ""
    @SerializedName("name")
    var name = ""
    @SerializedName("exchange")
    var exchange = ""
    @SerializedName("current_price")
    var current_price = 0f
}

@Entity(tableName = "orders")
class Order {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("order_id")
    var orderId = 0L
    @SerializedName("created_at")
    var createdAt = System.currentTimeMillis()
    @SerializedName("id")
    var id = ""
    @SerializedName("name")
    var name = ""
    @SerializedName("exchange")
    var exchange = ""
    @SerializedName("current_price")
    var current_price = 0f
    @SerializedName("order_type")
    var orderType = ""
    @SerializedName("quantity")
    var quantity = ""
    @SerializedName("cost")
    var cost = ""
}