package com.pixerapps.tradzee.ui.activity.home.fragments.dashboard

import android.content.Context
import com.pixerapps.tradzee.model.Stocks
import com.pixerapps.tradzee.mvp.BaseMvpPresenter
import com.pixerapps.tradzee.mvp.BaseMvpView

object DashboardContract {
    interface View : BaseMvpView {
        fun showMarketWatch(stocks : List<Stocks>)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadMarketWatch(context: Context)
    }
}