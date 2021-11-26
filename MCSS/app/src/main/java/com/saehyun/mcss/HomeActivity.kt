package com.saehyun.mcss.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.saehyun.mcss.R
import com.saehyun.mcss.base.BaseActivity
import com.saehyun.mcss.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>(
    R.layout.activity_home
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(binding.root)

//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_home)
//
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_list
//            )
//        )
//
//        navView.setupWithNavController(navController)
    }
}