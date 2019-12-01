package com.pixerapps.tradzee.ui.activity.home.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.mvp.BaseMvpFragment

class ProfileFragment : BaseMvpFragment<ProfileContract.View, ProfilePresenter>(),
    ProfileContract.View {
    override var presenter: ProfilePresenter = ProfilePresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}