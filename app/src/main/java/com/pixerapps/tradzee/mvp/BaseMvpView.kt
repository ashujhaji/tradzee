package com.pixerapps.tradzee.mvp

import android.app.Activity
import android.content.Context

interface BaseMvpView {
    fun getContext(): Context?
    fun showError(error : String?)
    fun showNoInternet()
    fun showToast(message : String?)
    fun showSnackbar(activity: Activity,message: String?)
}