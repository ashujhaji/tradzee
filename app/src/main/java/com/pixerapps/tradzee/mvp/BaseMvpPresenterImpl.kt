package com.pixerapps.tradzee.mvp


open class BaseMvpPresenterImpl<V: BaseMvpView> : BaseMvpPresenter<V> {

    protected var mView : V? = null
    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

    fun isViewAttached(): Boolean {
        return mView != null
    }

    fun getMvpView(): V {
        return mView!!
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")
}