package com.androidflux.assestment.androidflux

import android.app.Application
import com.androidflux.assestment.androidflux.MyApp.Companion.instance
import com.androidflux.assestment.androidflux.action.MyActionCreators
import com.hardsoftstudio.rxflux.RxFlux

class MyApp : Application() {
    lateinit var rxFlux: RxFlux
    lateinit var myActionCreator: MyActionCreators

    init {
        instance = this
    }

    companion object {
        private var instance: MyApp? = null

        fun getApp(): MyApp {
            return instance!!
        }
    }


    override fun onCreate() {
        super.onCreate()

        rxFlux = RxFlux.init(this)
        myActionCreator = MyActionCreators(rxFlux.dispatcher, rxFlux.subscriptionManager)
    }

    fun getApp(): MyApp = this

}