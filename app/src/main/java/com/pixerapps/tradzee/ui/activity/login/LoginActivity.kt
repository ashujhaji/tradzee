package com.pixerapps.tradzee.ui.activity.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pixerapps.tradzee.R
import com.pixerapps.tradzee.mvp.BaseMvpActivity
import com.pixerapps.tradzee.ui.activity.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseMvpActivity<LoginContract.View, LoginPresenter>(),
    LoginContract.View, View.OnClickListener {
    override var presenter: LoginPresenter = LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.login -> {
                val intent = Intent(this, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
    }
}