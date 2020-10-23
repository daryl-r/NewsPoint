package com.daryl.newsviewer.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.daryl.newsviewer.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * @author Daryl Richardson
 */
class SplashActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Observable.interval(3, TimeUnit.SECONDS)
            .take(1)
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { aLong -> navigateToHome() }
    }

    private fun navigateToHome() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
        finish()
    }
}
