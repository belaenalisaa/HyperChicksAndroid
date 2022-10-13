package com.bela.hyperchicks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bela.hyperchicks.activity.LoginActivity
import com.bela.hyperchicks.fragment.AboutFragment
import com.bela.hyperchicks.fragment.AkunFragment
import com.bela.hyperchicks.fragment.HomeFragment
import com.bela.hyperchicks.fragment.MenuFragment
import com.bela.hyperchicks.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fragmentHome: Fragment = HomeFragment()
    private val fragmentMenu: Fragment = MenuFragment()
    private val fragmentAbout: Fragment = AboutFragment()
    private val fragmentAkun: Fragment = AkunFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var  menuItem: MenuItem
    private lateinit var  bottomNavigationView: BottomNavigationView

    private val statusLogin = false

    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

    setUpBottomNav()
    }
    fun setUpBottomNav(){
        fm.beginTransaction().add(R.id.nav_host_fragment, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragmentMenu).hide(fragmentMenu).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragmentAbout).hide(fragmentAbout)
            .commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragmentAkun).hide(fragmentAkun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_home -> {
                    callFragment(0,fragmentHome)
                }
                R.id.navigation_menu -> {
                    callFragment(1,fragmentMenu)
                }
                R.id.navigation_about -> {
                    callFragment(2,fragmentAbout)
                }
                R.id.navigation_akun -> {
                    if (s.getStatusLogin()){
                    callFragment(3,fragmentAkun)
                    } else {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
            }
            false
        }
    }

    fun callFragment(int: Int, fragment: Fragment) {
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}