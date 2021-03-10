package com.muhammadprajadinata.bottexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.muhammadprajadinata.bottexample.Fragment.HomeFragment
import com.muhammadprajadinata.bottexample.Fragment.KategoriFragment
import com.muhammadprajadinata.bottexample.Fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavListener)

        val frag = supportFragmentManager.beginTransaction()
        frag.add(R.id.fragContainer, HomeFragment())
        frag.commit()
    }

    private val onBottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener { i->
        var selectedFragment: Fragment = HomeFragment()

        when(i.itemId) {
            R.id.item_home -> {
                selectedFragment = HomeFragment()
            }

            R.id.item_search -> {
                selectedFragment = SearchFragment()
            }

            R.id.item_kategori -> {
                selectedFragment = KategoriFragment()
            }
        }

        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.fragContainer, selectedFragment)
        frag.commit()

        true
    }
}