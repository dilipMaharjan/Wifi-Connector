package com.androidflux.assestment.androidflux.dagger

import com.androidflux.assestment.androidflux.MainActivity
import com.androidflux.assestment.androidflux.dagger.module.ActionCreatorModule
import com.androidflux.assestment.androidflux.dagger.module.AndroidModule
import com.androidflux.assestment.androidflux.dagger.module.StoreModule
import dagger.Component
import javax.inject.Singleton

/**
 *
 *   Created by Dilip Maharjan on 06-06-2018
 */
@Singleton
@Component(modules = [(AndroidModule::class), (ActionCreatorModule::class), (StoreModule::class)])

interface ApplicationComponent {
    fun inject(activity: MainActivity)

}