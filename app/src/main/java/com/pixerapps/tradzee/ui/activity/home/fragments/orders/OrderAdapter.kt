package com.pixerapps.tradzee.ui.activity.home.fragments.orders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.model.Order
import kotlinx.android.extensions.LayoutContainer

class OrderAdapter(
    private val orders: List<Order>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_order, parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(orders[position])
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(repository: Order) {
            containerView.findViewById<TextView>(R.id.entityName).text = repository.name
            containerView.findViewById<TextView>(R.id.entityId).text = repository.id
            containerView.findViewById<TextView>(R.id.entityCost).text =
                "$" + repository.cost
            containerView.findViewById<TextView>(R.id.orderType).text = repository.orderType
        }
    }
}