package com.pixerapps.tradzee.ui.activity.home.fragments.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.model.Order
import com.pixerapps.tradzee.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_orders.*

class OrdersFragment : BaseMvpFragment<OrdersContract.View, OrdersPresenter>(),
    OrdersContract.View, SwipeRefreshLayout.OnRefreshListener {
    override var presenter: OrdersPresenter = OrdersPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //methods
        presenter.loadOrders(context!!)
    }

    override fun showOrders(orders: List<Order>) {
        refreshLayout.isRefreshing = false
        orderRecycler.layoutManager = LinearLayoutManager(context!!)
        orderRecycler.adapter = OrderAdapter(orders)
        refreshLayout.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        presenter.loadOrders(context!!)
    }

    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        if (menuVisible){
            presenter.loadOrders(context!!)
        }
    }
}