package com.pixerapps.tradzee.mvp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseMvpActivity<in V : BaseMvpView, T : BaseMvpPresenter<V>> : AppCompatActivity(), BaseMvpView {

    protected abstract var presenter: T

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        presenter.attachView(this as V)
    }

    override fun getContext(): Context = this

    override fun showError(error: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToast(message: String?) {
        Toast.makeText(this,message!!,Toast.LENGTH_SHORT).show()
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