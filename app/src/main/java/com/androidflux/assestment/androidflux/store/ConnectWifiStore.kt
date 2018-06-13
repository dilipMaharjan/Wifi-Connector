package com.androidflux.assestment.androidflux.store

import android.util.Log
import com.hardsoftstudio.rxflux.action.RxAction
import com.hardsoftstudio.rxflux.dispatcher.Dispatcher
import com.hardsoftstudio.rxflux.store.RxStore
import com.hardsoftstudio.rxflux.store.RxStoreChange

/**
 *
 *   Created by Dilip Maharjan on 07-06-2018
 */
class ConnectWifiStore(dispatcher: Dispatcher) : RxStore(dispatcher) {
    private val TAG = "CONNECT_WIFI_STORE"

    override fun onRxAction(action: RxAction) {
        when (action.type) {
            "WIFI_CONNECTION" -> {
                Log.i(TAG, "Action Received")
            }
        }
        postChange(RxStoreChange("CONNECT_WIFI_STORE", action))
    }
}