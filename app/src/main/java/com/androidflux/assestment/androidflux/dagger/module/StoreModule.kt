package com.androidflux.assestment.androidflux.dagger.module

import com.androidflux.assestment.androidflux.store.NumberStore
import com.hardsoftstudio.rxflux.RxFlux
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 *   Created by Dilip Maharjan on 06-06-2018
 */
@Singleton
@Module
class StoreModule(val rxFlux: RxFlux) {
    @Provides
    @Singleton
    fun providesNumberStore() = NumberStore(rxFlux.dispatcher)


}