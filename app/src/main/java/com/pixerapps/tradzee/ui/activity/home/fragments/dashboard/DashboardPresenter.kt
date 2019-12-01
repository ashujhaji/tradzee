package com.pixerapps.tradzee.ui.activity.home.fragments.dashboard

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.pixerapps.tradzee.model.MarketWatch
import com.pixerapps.tradzee.mvp.BaseMvpPresenterImpl
import java.io.IOException
import java.io.InputStreamReader

class DashboardPresenter : BaseMvpPresenterImpl<DashboardContract.View>(),
    DashboardContract.Presenter {

    override fun loadMarketWatch(context: Context) {
        //since we have to parse local data, which we can achieve by using Gson. To retrieve data from server, we have to create an api call
        try {
            val assetManager = context.assets as AssetManager
            val ims = assetManager.open("marketwatch.json")
            val gson = Gson()
            val reader = InputStreamReader(ims)
            val marketWatch = gson.fromJson(reader, MarketWatch::class.java)
            mView?.showMarketWatch(marketWatch.stocks)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}