package com.androidflux.assestment.androidflux.action

import android.content.Context

/**
 *
 *   Created by Dilip Maharjan on 07-06-2018
 */
interface ConnectWifiAction {
    fun connectWifi(context: Context, ssid: String, password: String)
}