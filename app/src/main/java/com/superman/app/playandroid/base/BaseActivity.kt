package com.superman.app.playandroid.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.superman.app.playandroid.MainActivity
import com.superman.app.playandroid.R
import com.superman.app.playandroid.databinding.ActivityBaseBinding
import com.superman.app.playandroid.databinding.ActivityMainBinding

/**
 *
 * @author superman
 * @date 2019-10-09
 */
abstract class BaseActivity: AppCompatActivity() {

    protected lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        var contentView =
            DataBindingUtil.setContentView<ActivityBaseBinding>(this, R.layout.activity_base).apply {
                initView(layoutContainer)
            }

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        initData()
    }


    abstract fun getLayoutId(): Int

    abstract fun initView(viewGroup: ViewGroup)

    open fun initData(){}

    fun showLine(iShow: Boolean) {

    }


}