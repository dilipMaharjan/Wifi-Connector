package com.androidflux.assestment.androidflux.dagger.module

import com.androidflux.assestment.androidflux.action.ConnectWifiActionCreator
import com.hardsoftstudio.rxflux.RxFlux
import com.hardsoftstudio.rxflux.action.RxActionCreator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 *   Created by Dilip Maharjan on 06-06-2018
 */
@Module
class ActionCreatorModule(val rxFlux: RxFlux) {

    @Singleton
    @Provides
    fun providesActionCreator() = ConnectWifiActionCreator(rxFlux.dispatcher, rxFlux.subscriptionManager)
}
