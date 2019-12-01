package com.pixerapps.tradzee.mvp

interface BaseMvpPresenter<in V: BaseMvpView> {
    fun attachView(view : V)
    fun detachView()
}