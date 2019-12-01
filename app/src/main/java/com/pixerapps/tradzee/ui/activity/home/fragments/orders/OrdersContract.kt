package com.pixerapps.tradzee.ui.activity.home.fragments.orders

import android.content.Context
import com.pixerapps.tradzee.model.Order
import com.pixerapps.tradzee.mvp.BaseMvpPresenter
import com.pixerapps.tradzee.mvp.BaseMvpView

object OrdersContract {
    interface View : BaseMvpView {
        fun showOrders(orders: List<Order>)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadOrders(context: Context)
    }
}