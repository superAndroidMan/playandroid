package com.superman.app.playandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.superman.app.playandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var contentView: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("首页")
        contentView = DataBindingUtil.setContentView<ActivityMainBinding>(this, getLayoutId())
        navController = Navigation.findNavController(this, R.id.fragment_home)
//        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        initBottomNavigation()
    }

    fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    private fun initBottomNavigation() {
        contentView.bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            setTitle(destination.label)
        }
    }

}
