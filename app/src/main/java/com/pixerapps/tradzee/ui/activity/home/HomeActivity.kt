package com.pixerapps.tradzee.ui.activity.home

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.mvp.BaseMvpActivity
import com.pixerapps.tradzee.ui.activity.home.fragments.dashboard.DashboardFragment
import com.pixerapps.tradzee.ui.activity.home.fragments.orders.OrdersFragment
import com.pixerapps.tradzee.ui.activity.home.fragments.profile.ProfileFragment
import com.pixerapps.tradzee.util.Config
import com.pixerapps.tradzee.util.Constant
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseMvpActivity<HomeContract.View, HomePresenter>(),
    HomeContract.View, BottomNavigationView.OnNavigationItemSelectedListener {
    override var presenter: HomePresenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //methods
        addFragments()


        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun addFragments() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(DashboardFragment(), Constant.FRAGMENT_DASHBOARD)
        adapter.addFragment(OrdersFragment(), Constant.FRAGMENT_ORDERS)
        adapter.addFragment(ProfileFragment(), Constant.FRAGMENT_PROFILE)
        mainViewPager.adapter = adapter
        mainViewPager.offscreenPageLimit = 3
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.menu_dashboard -> {
                mainViewPager.currentItem = 0
                return true
            }
            R.id.menu_orders -> {
                mainViewPager.currentItem = 1
                return true
            }
            R.id.menu_profile -> {
                mainViewPager.currentItem = 2
                return true
            }
        }
        return false
    }

    override fun onBackPressed() {
        if (supportFragmentManager.findFragmentByTag(Constant.PLACE_ORDER_DIALOG) != null) {
            Config.dismissDialogFragment(this, Constant.PLACE_ORDER_DIALOG)
        }else finishAffinity()
    }
}