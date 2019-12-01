package com.pixerapps.tradzee.mvp

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseMvpFragment<in V : BaseMvpView, T : BaseMvpPresenter<V>> : Fragment(),
    BaseMvpView {

    protected abstract var presenter: T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun showError(error: String?) {

    }

    override fun showToast(message: String?) {

    }

    override fun showSnackbar(activity: Activity, message: String?) {

    }

    override fun showNoInternet() {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}