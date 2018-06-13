package com.androidflux.assestment.androidflux.action

import android.content.Context
import android.util.Log
import com.androidflux.assestment.androidflux.utilities.connect
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
    override fun connectWifi(context: Context, ssid: String, password: String) {
        val action = newRxAction("WIFI_CONNECTION")
        addRxAction(action,
                connect(context, ssid, password).subscribe {
                    postRxAction(newRxAction("WIFI_CONNECTION", "status", it))
                })
    }
}