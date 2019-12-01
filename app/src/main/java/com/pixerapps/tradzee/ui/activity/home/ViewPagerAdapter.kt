package com.pixerapps.tradzee.ui.activity.home

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.lang.ref.WeakReference
import java.util.*

class ViewPagerAdapter internal constructor(manager: FragmentManager) : FragmentPagerAdapter(manager) {
    private val instantiatedFragments = SparseArray<WeakReference<Fragment>>()
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    internal fun addFragment(fragment: Fragment, title: String) {
        if (!mFragmentList.contains(fragment)) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        instantiatedFragments.put(position, WeakReference(fragment))
        return fragment
    }

    internal fun getFragment(position: Int): Fragment? {
        val wr = instantiatedFragments.get(position)
        return wr?.get()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
}