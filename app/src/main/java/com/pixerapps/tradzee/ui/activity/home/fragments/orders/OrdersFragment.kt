package com.pixerapps.tradzee.ui.activity.home.fragments.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.mvp.BaseMvpFragment

class OrdersFragment : BaseMvpFragment<OrdersContract.View, OrdersPresenter>(),
    OrdersContract.View {
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
    }
}