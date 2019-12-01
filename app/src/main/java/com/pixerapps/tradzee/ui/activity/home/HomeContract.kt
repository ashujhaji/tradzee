package com.pixerapps.tradzee.ui.activity.home

import com.pixerapps.tradzee.mvp.BaseMvpPresenter
import com.pixerapps.tradzee.mvp.BaseMvpView

object HomeContract {
    interface View : BaseMvpView {
        fun addFragments()
    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}