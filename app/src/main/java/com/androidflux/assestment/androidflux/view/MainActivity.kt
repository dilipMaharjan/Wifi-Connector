package com.androidflux.assestment.androidflux.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.androidflux.assestment.androidflux.MyApp
import com.androidflux.assestment.androidflux.R
import com.androidflux.assestment.androidflux.store.ConnectWifiStore
import com.hardsoftstudio.rxflux.action.RxError
import com.hardsoftstudio.rxflux.dispatcher.RxViewDispatch
import com.hardsoftstudio.rxflux.store.RxStore
import com.hardsoftstudio.rxflux.store.RxStoreChange
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RxViewDispatch {

    private val TAG = "MAINACTIVITY"

    private lateinit var wifiStore: ConnectWifiStore
    var status = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnConnect.setOnClickListener {
            MyApp.getApp().actionCreators.connectWifi(this, "TravelTab", "123456789")
        }
    }

    override fun onRxViewUnRegistered() {

    }

    override fun getRxStoreListToUnRegister(): MutableList<RxStore> {
        return mutableListOf(wifiStore)
    }

    override fun onRxViewRegistered() {
    }

    override fun onRxError(error: RxError) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

    override fun getRxStoreListToRegister(): MutableList<RxStore?> {
        wifiStore = ConnectWifiStore(MyApp.getApp().rxFlux.dispatcher)
        return mutableListOf(wifiStore)
    }

    override fun onRxStoreChanged(change: RxStoreChange) {
        when (change.storeId) {
            "CONNECT_WIFI_STORE" -> {
                status = change.rxAction.get<Boolean>("status")
                if (status) {
                    statusTv.text = "Connection Successful"
                }
            }
        }
    }
}