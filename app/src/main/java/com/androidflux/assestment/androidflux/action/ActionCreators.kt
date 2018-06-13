package com.androidflux.assestment.androidflux.action

import android.content.Context
import com.androidflux.assestment.androidflux.utilities.connect
import com.hardsoftstudio.rxflux.action.RxActionCreator
import com.hardsoftstudio.rxflux.dispatcher.Dispatcher
import com.hardsoftstudio.rxflux.util.SubscriptionManager

/**
 *
 *   Created by Dilip Maharjan on 07-06-2018
 */
class ActionCreators(dispatcher: Dispatcher, subscriptionManager: SubscriptionManager) : RxActionCreator(dispatcher, subscriptionManager), ConnectWifiAction {
    private val TAG = "ConnectWifiActionCreators"
    override fun connectWifi(context: Context, ssid: String, password: String) {
        val action = newRxAction("WIFI_CONNECTION")
        addRxAction(action,
                connect(context, ssid, password).subscribe {
                    postRxAction(newRxAction("WIFI_CONNECTION", "status", it))
                })
    }
}