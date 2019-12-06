package com.superman.app.playandroid

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.superman.app.playandroid.base.BaseActivity
import com.superman.app.playandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController
    override fun initData() {

    }

    override fun initView(viewGroup: ViewGroup) {
        setTitle("首页")

        val activityMainBinding = DataBindingUtil.inflate<ActivityMainBinding>(
            layoutInflater,
            getLayoutId(),
            viewGroup,
            true
        )

        navController = Navigation.findNavController(this, R.id.fragment_home)
        initBottomNavigation(activityMainBinding)

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    private fun initBottomNavigation(activityMainBinding: ActivityMainBinding) {
        activityMainBinding.bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            setTitle(destination.label)
        }
    }

}
