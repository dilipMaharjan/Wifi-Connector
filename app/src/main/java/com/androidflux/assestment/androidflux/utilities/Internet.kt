package com.androidflux.assestment.androidflux.utilities

import android.content.Context
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import android.util.Log
import rx.Observable

/**
 *
 *   Created by Dilip Maharjan on 12-06-2018
 */

fun connect(context: Context, networkSSID: String, password: String): Observable<Boolean> {
    try {
        val conf = WifiConfiguration()
        conf.SSID = "\"" + networkSSID + "\""

        conf.preSharedKey = "\"" + password + "\""

        conf.status = WifiConfiguration.Status.ENABLED
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP)
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP)
        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK)
        conf.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP)
        conf.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP)

        Log.d("connecting", conf.SSID + " " + conf.preSharedKey)

        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.addNetwork(conf)

        Log.d("after connecting", conf.SSID + " " + conf.preSharedKey)


        val list = wifiManager.configuredNetworks
        for (i in list) {
            if (i.SSID != null && i.SSID == "\"" + networkSSID + "\"") {
                wifiManager.disconnect()
                wifiManager.enableNetwork(i.networkId, true)
                wifiManager.reconnect()
                Log.d("re connecting", i.SSID + " " + conf.preSharedKey)
                break
            }
        }
        return Observable.just(true)
    } catch (ex: Exception) {
        return Observable.just(false)
    }

}