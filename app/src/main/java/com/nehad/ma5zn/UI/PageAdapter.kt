package com.nehad.ma5zn.UI

import android.icu.text.CaseMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.sql.DatabaseMetaData

class PageAdapter (supportFragmentManager: FragmentManager): FragmentPagerAdapter(supportFragmentManager ,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private  val  mFragmentList = ArrayList<Fragment>();
    private  val  mFragmentTitleList  = ArrayList<String>();


    override fun getCount(): Int {
        return  mFragmentList.size
//        return 3
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
//        when (position){
//            0 -> { return Ma5znFragment()}
//            1 -> { return Ma5zn2Fragment()}
//            2 -> { return Ma5zn3Fragment()}
//            else ->{return Ma5zn2Fragment()}
//        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
//        when (position) {
//            0 -> { return "Inventory 1" }
//            1 -> { return "Inventory 2" }
//            2 -> { return "Inventory 3" }
//        }
//        return super.getPageTitle(position)
  //  }
    fun addFragment (fragment: Fragment , title: String){
    mFragmentList.add(fragment)
    mFragmentTitleList.add(title)

}

}