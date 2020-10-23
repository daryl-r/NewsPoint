package com.daryl.newsviewer.ui

import android.os.Bundle
import com.daryl.newsviewer.R

/**
 * @author Daryl Richardson
 */
class HomeActivity : BaseActivity() {

    private var newsFragment: NewsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        showSourceFragment()
    }

    private fun showSourceFragment() {
        newsFragment = NewsFragment()
        addFragment(newsFragment!!, R.id.container, "NewsFragment")
    }

    override fun onBackPressed() {
        if (!newsFragment?.onBackPressed()!!)
            super.onBackPressed()
    }
}