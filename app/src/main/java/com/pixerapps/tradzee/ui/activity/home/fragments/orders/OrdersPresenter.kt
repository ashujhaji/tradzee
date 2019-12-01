package com.pixerapps.tradzee.ui.activity.home.fragments.orders

import android.content.Context
import com.pixerapps.tradzee.data.local.TradzeeDb
import com.pixerapps.tradzee.mvp.BaseMvpPresenterImpl
import rx.schedulers.Schedulers

class OrdersPresenter : BaseMvpPresenterImpl<OrdersContract.View>(),
    OrdersContract.Presenter {

    override fun loadOrders(context: Context) {
        mView?.showOrders(TradzeeDb.getAppDatabase(context).tradzeeRoomDao().getOrders())
    }
}