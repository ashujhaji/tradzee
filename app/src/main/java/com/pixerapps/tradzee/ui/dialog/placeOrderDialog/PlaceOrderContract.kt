package com.pixerapps.tradzee.ui.dialog.placeOrderDialog

import android.content.Context
import com.pixerapps.tradzee.model.Stocks
import com.pixerapps.tradzee.mvp.BaseMvpPresenter
import com.pixerapps.tradzee.mvp.BaseMvpView

object PlaceOrderContract {
    interface View : BaseMvpView {
        fun onOrderedSuccess()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun placeOrder(
            context: Context,
            stock: Stocks,
            orderType: String,
            quantity: String,
            cost: String
        )
    }
}