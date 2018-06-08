package com.androidflux.assestment.androidflux.action

import android.util.Log
import com.hardsoftstudio.rxflux.action.RxActionCreator
import com.hardsoftstudio.rxflux.dispatcher.Dispatcher
import com.hardsoftstudio.rxflux.util.SubscriptionManager
import rx.Observable

/**
 *
 *   Created by Dilip Maharjan on 07-06-2018
 */
class MyActionCreators(dispatcher: Dispatcher, subscriptionManager: SubscriptionManager) : RxActionCreator(dispatcher, subscriptionManager), MyAction {
    private val TAG = "MyActionCreator"
    override fun connectWifi() {
        val action = newRxAction("WIFI_CONNECTION")
        addRxAction(action,
                connect().subscribe {
                    postRxAction(newRxAction("WIFI_CONNECTION", "status", it))
                })
    }

    private fun connect(): Observable<Boolean> {
        return Observable.just(false).map { true }
    }
}