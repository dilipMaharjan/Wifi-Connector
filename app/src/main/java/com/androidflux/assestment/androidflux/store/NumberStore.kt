package com.androidflux.assestment.androidflux.store

import com.hardsoftstudio.rxflux.action.RxAction
import com.hardsoftstudio.rxflux.dispatcher.Dispatcher
import com.hardsoftstudio.rxflux.store.RxStore
import com.hardsoftstudio.rxflux.store.RxStoreChange


/**
 *
 *   Created by Dilip Maharjan on 06-06-2018
 */
class NumberStore(dispatcher: Dispatcher) : RxStore(dispatcher), NumberStoreInterface {

    var numberList: List<Int>? = null

    override fun getNumbers(): List<Int>? {
        return numberList
    }

    override fun onRxAction(action: RxAction) {
        when (action.type) {
            "NUMBER" -> {
                numberList = action.get("NUMBER")
            }
        }
        postChange(RxStoreChange("NumberStore", action))
    }
}