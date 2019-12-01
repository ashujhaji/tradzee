package com.pixerapps.tradzee.ui.activity.home.fragments.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.model.Stocks
import com.pixerapps.tradzee.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : BaseMvpFragment<DashboardContract.View, DashboardPresenter>(),
    DashboardContract.View {
    override var presenter: DashboardPresenter = DashboardPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //methods
        refreshLayout.isRefreshing = true
        presenter.loadMarketWatch(context!!)
    }

    override fun showMarketWatch(stocks: List<Stocks>) {
        refreshLayout.isRefreshing = false
        stockRecycler.layoutManager = LinearLayoutManager(context)
        stockRecycler.adapter = StocksAdapter(stocks, activity!!)
    }
}