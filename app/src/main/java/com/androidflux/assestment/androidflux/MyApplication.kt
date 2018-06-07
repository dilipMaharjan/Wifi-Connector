package com.androidflux.assestment.androidflux

import android.app.Application
import com.androidflux.assestment.androidflux.dagger.ApplicationComponent
import com.androidflux.assestment.androidflux.dagger.DaggerApplicationComponent
import com.androidflux.assestment.androidflux.dagger.module.ActionCreatorModule
import com.androidflux.assestment.androidflux.dagger.module.AndroidModule
import com.androidflux.assestment.androidflux.dagger.module.StoreModule
import com.hardsoftstudio.rxflux.RxFlux
import javax.inject.Inject

/**
 *
 *   Created by Dilip Maharjan on 06-06-2018
 */
class MyApplication : Application() {
    private val TAG = "MYAPPLICATION"

    lateinit var component: ApplicationComponent

    @Inject
    lateinit var rxFlux: RxFlux

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent
                .builder()
                .androidModule(AndroidModule(this))
                .actionCreatorModule(ActionCreatorModule(rxFlux))
                .storeModule(StoreModule(rxFlux))
                .build()
    }
}