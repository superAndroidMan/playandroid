package com.superman.app.playandroid.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.superman.app.playandroid.R
import com.superman.app.playandroid.base.mvp.BaseMVPFragment
import com.superman.app.playandroid.bean.Entity
import com.superman.app.playandroid.home.HomeContract
import com.superman.app.playandroid.home.HomePresenter
import kotlinx.android.synthetic.main.home_fragment_layout.*
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @author superman
 * @date 2019-10-09
 */
class HomeFragment : BaseMVPFragment<HomeContract.View,HomePresenter>(),HomeContract.View {

    private var entities: MutableList<Entity> = ArrayList()
    override fun createPresenter(): HomePresenter = HomePresenter()

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
        for (i in 0..99) {
            entities.add(Entity())
        }
        recyclerview.layoutManager = LinearLayoutManager(mContext)
        recyclerview.adapter = MyAdapter(entities)
    }

    override fun getLayoutResId(): Int = R.layout.home_fragment_layout

    internal class MyAdapter( data: List<Entity?>?) :
        BaseQuickAdapter<Entity?, BaseViewHolder?>(R.layout.item_rv, data) {
        override fun convert(helper: BaseViewHolder?, item: Entity?) {}
    }

}