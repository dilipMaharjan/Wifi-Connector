package com.androidflux.assestment.androidflux

import android.app.Application
import com.androidflux.assestment.androidflux.action.ActionCreators
import com.hardsoftstudio.rxflux.RxFlux

class MyApp : Application() {
    lateinit var rxFlux: RxFlux
    lateinit var actionCreators: ActionCreators

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
        actionCreators = ActionCreators(rxFlux.dispatcher, rxFlux.subscriptionManager)
    }

    fun getApp(): MyApp = this

}