package com.nehad.ma5zn.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nehad.ma5zn.R
import com.nehad.ma5zn.UI.ma5zn2.Ma5zn2Fragment
import com.nehad.ma5zn.UI.ma5zn3.Ma5zn3Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupTabs()
//        viewpager.adapter = PageAdapter(supportFragmentManager)
//        tablayout.setupWithViewPager(viewpager)
    }

    private fun setupTabs() {
        val adapter = PageAdapter(supportFragmentManager)
        adapter.addFragment(Ma5zn2Fragment(),"Inventory 1")
        adapter.addFragment(Ma5zn2Fragment(),"Inventory 2")
        adapter.addFragment(Ma5zn3Fragment(),"Inventory 3")
        viewpager.adapter  = adapter
        tablayout.setupWithViewPager(viewpager)
        tablayout.getTabAt(0)!!.setIcon(R.drawable.ic_inventory)
        tablayout.getTabAt(1)!!.setIcon(R.drawable.ic_invoice)
        tablayout.getTabAt(2)!!.setIcon(R.drawable.ic_inventory)

    }
}