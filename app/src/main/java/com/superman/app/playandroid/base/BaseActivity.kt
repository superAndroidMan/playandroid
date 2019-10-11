package com.superman.app.playandroid.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.superman.app.playandroid.R
import com.superman.app.playandroid.databinding.ActivityBaseBinding

/**
 *
 * @author superman
 * @date 2019-10-09
 */
abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this

//        var contentView =
//            DataBindingUtil.setContentView<ActivityBaseBinding>(this, R.layout.activity_base).apply {
//                LayoutInflater.from(mContext).inflate(getLayoutId(), viewPager)
//            }
        setContentView(getLayoutId())
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        initView()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    fun showLine(iShow: Boolean) {

    }

}