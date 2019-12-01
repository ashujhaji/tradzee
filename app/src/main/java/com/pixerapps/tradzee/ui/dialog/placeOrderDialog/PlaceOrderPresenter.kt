package com.pixerapps.tradzee.ui.dialog.placeOrderDialog

import android.content.Context
import com.pixerapps.tradzee.data.local.TradzeeDb
import com.pixerapps.tradzee.model.Order
import com.pixerapps.tradzee.model.Stocks
import com.pixerapps.tradzee.mvp.BaseMvpPresenterImpl

class PlaceOrderPresenter : BaseMvpPresenterImpl<PlaceOrderContract.View>(),
    PlaceOrderContract.Presenter {

    override fun placeOrder(
        context: Context,
        stock: Stocks,
        orderType: String,
        quantity: String,
        cost: String
    ) {
        val order = Order()
        order.id = stock.id
        order.name = stock.name
        order.cost = cost
        order.quantity = quantity
        order.orderType = orderType
        TradzeeDb.getAppDatabase(context).tradzeeRoomDao().insertOrder(order)
        mView?.onOrderedSuccess()
    }
}