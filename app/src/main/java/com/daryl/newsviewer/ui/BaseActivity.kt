package com.daryl.newsviewer.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


/**
 * @author Daryl Richardson
 */
open class BaseActivity : FragmentActivity() {

    fun addFragment(fragment: Fragment, layoutResId: Int, tag: String) {
        supportFragmentManager.beginTransaction()
            .add(layoutResId, fragment, tag)
            .commit()
    }

    fun addFragmentWithBackStack(fragment: Fragment, layoutResId: Int, tag: String) {
        supportFragmentManager.beginTransaction()
            .add(layoutResId, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }
}