package com.androidflux.assestment.androidflux.dagger.module

import android.app.Application
import com.hardsoftstudio.rxflux.RxFlux
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 *   Created by Dilip Maharjan on 06-06-2018
 */
@Module
class AndroidModule(val application: Application) {

    @Provides
    @Singleton
    fun providesApplication() = application

    @Singleton
    @Provides
    fun providesRxFlux(): RxFlux = RxFlux.init(application)

}