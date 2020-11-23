package com.kbkapps.mystockmanager.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kbkapps.mystockmanager.R

private val TAB_TITLES = arrayOf(
    R.string.bill_tab,
    R.string.manage_tab,
    R.string.view_tab
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        return when (position) {
            context.resources.getInteger(R.integer.bill_tab) -> BillingFragment.newInstance()
            context.resources.getInteger(R.integer.stock_tab) -> ManageStockFragment.newInstance()
            else -> ViewStocksFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}