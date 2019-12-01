package com.pixerapps.tradzee.ui.dialog.placeOrderDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.model.Stocks
import com.pixerapps.tradzee.mvp.BaseMvpDialogFragment
import kotlinx.android.synthetic.main.dialog_place_order.*

class PlaceOrderDialog : BaseMvpDialogFragment<PlaceOrderContract.View, PlaceOrderPresenter>(),
    PlaceOrderContract.View, View.OnClickListener {
    override var presenter: PlaceOrderPresenter = PlaceOrderPresenter()
    private lateinit var stock: Stocks

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_place_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        if (bundle != null) {
            stock = bundle.getSerializable("stock") as Stocks
            orderType.text = bundle.getString("orderType")
            confirmOrder.setOnClickListener(this)
        }

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.confirmOrder -> {
                if (quantity.text.toString().isNotEmpty() && cost.text.toString().isNotEmpty()) {
                    dismiss()
                } else Toast.makeText(context!!, "Fields are empty", Toast.LENGTH_LONG).show()
            }
        }
    }


    companion object {

        fun getInstance(
            orderType: String,
            stocks: Stocks
        ): PlaceOrderDialog {
            val myFragment = PlaceOrderDialog()
            val args = Bundle()
            args.putString("orderType", orderType)
            args.putSerializable("stock", stocks)
            myFragment.arguments = args
            return myFragment
        }
    }
}