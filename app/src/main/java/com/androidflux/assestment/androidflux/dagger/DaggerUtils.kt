package com.androidflux.assestment.androidflux.dagger

import android.support.v7.app.AppCompatActivity
import com.androidflux.assestment.androidflux.Application

/**
 *
 *   Created by Dilip Maharjan on 07-06-2018
 */

val AppCompatActivity.component: ApplicationComponent
    get() = (application as Application).component