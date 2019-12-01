package com.pixerapps.tradzee.util

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

object Config {
    fun showDialogFragment(
        fragmentActivity: FragmentActivity,
        dialogFragment: DialogFragment,
        tag: String
    ) {
        val fragmentManager = fragmentActivity.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.replace(android.R.id.content, dialogFragment, tag).addToBackStack(null).commit()
    }

    fun dismissDialogFragment(fragmentActivity: FragmentActivity, tag: String) {
        val prev = fragmentActivity.supportFragmentManager.findFragmentByTag(tag)
        if (prev != null) {
            val df = prev as DialogFragment
            df.dismiss()
            fragmentActivity.supportFragmentManager.popBackStack()
        }
    }
}