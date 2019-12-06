package com.superman.app.playandroid

import android.app.Application
import android.content.Context

/**
 * @author superman
 * @date 2019-10-23
 */
class AppContext : Application(){

    companion object {
        private lateinit var context: Context

        private lateinit var instance: AppContext

        fun getContext(): Context {
            return context.applicationContext
        }

        fun getInstance(): AppContext {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        instance = this
    }

}
