package com.pixerapps.tradzee.model

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
    @SerializedName("order_type")
    var orderType = ""
}