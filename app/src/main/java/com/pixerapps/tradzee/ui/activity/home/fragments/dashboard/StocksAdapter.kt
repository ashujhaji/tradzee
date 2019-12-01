package com.pixerapps.tradzee.ui.activity.home.fragments.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.model.Stocks
import com.pixerapps.tradzee.ui.dialog.placeOrderDialog.PlaceOrderDialog
import com.pixerapps.tradzee.util.Config
import com.pixerapps.tradzee.util.Constant
import kotlinx.android.extensions.LayoutContainer

class StocksAdapter(
    private val list: List<Stocks>,
    private val fragmentActivity: FragmentActivity
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_stock, parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(list[position], fragmentActivity)
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(repository: Stocks, fragmentActivity: FragmentActivity) {
            containerView.findViewById<TextView>(R.id.entityName).text = repository.name
            containerView.findViewById<TextView>(R.id.entityId).text = repository.id
            containerView.findViewById<TextView>(R.id.entityCost).text =
                "$" + repository.current_price
            containerView.findViewById<Button>(R.id.buy).setOnClickListener {
                Config.showDialogFragment(
                    fragmentActivity,
                    PlaceOrderDialog.getInstance(Constant.BUY, repository),
                    Constant.PLACE_ORDER_DIALOG
                )
            }
            containerView.findViewById<Button>(R.id.sell).setOnClickListener {
                Config.showDialogFragment(
                    fragmentActivity,
                    PlaceOrderDialog.getInstance(Constant.SELL, repository),
                    Constant.PLACE_ORDER_DIALOG
                )
            }

        }
    }
}