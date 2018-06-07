package com.androidflux.assestment.androidflux.action

import com.hardsoftstudio.rxflux.action.RxActionCreator
import com.hardsoftstudio.rxflux.dispatcher.Dispatcher
import com.hardsoftstudio.rxflux.util.SubscriptionManager
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 *
 *   Created by Dilip Maharjan on 06-06-2018
 */
class ConnectWifiActionCreator(dispatcher: Dispatcher, manager: SubscriptionManager) : RxActionCreator(dispatcher, manager), Actions {

    override fun getNumbers() {
        val action = newRxAction("NUMBER")
        addRxAction(action, Observable.from(listOf(1, 2, 3, 4))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ number -> postRxAction(newRxAction("NUMBER", number)) }, { throwable -> postError(action, throwable) }))
    }
}

