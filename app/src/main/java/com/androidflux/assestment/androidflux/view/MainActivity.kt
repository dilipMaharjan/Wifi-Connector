package com.androidflux.assestment.androidflux.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.androidflux.assestment.androidflux.MyApp
import com.androidflux.assestment.androidflux.R
import com.androidflux.assestment.androidflux.action.MyActionCreators
import com.androidflux.assestment.androidflux.store.MyStore
import com.hardsoftstudio.rxflux.RxFlux
import com.hardsoftstudio.rxflux.action.RxError
import com.hardsoftstudio.rxflux.dispatcher.RxViewDispatch
import com.hardsoftstudio.rxflux.store.RxStore
import com.hardsoftstudio.rxflux.store.RxStoreChange
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RxViewDispatch {

    private val TAG = "MAINACTIVITY"

    lateinit var myStore: MyStore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnConnect.setOnClickListener {
            MyApp.getApp().myActionCreator.connectWifi(this, "TravelTab", "123456789")
        }

    }

    override fun onRxViewUnRegistered() {

    }

    override fun getRxStoreListToUnRegister(): MutableList<RxStore> {
        return mutableListOf(myStore)
    }

    override fun onRxViewRegistered() {
    }

    override fun onRxError(error: RxError) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

    override fun getRxStoreListToRegister(): MutableList<RxStore?> {
        myStore = MyStore(MyApp.getApp().rxFlux.dispatcher)
        return mutableListOf(myStore)
    }

    override fun onRxStoreChanged(change: RxStoreChange) {
        when (change.storeId) {
            "MY_STORE" -> {
                if (change.rxAction.get<Boolean>("status")) {
                    status.text = "Connection Successful"
                } else {
                    status.text = "Connection Failed"
                }
            }
        }
    }
}