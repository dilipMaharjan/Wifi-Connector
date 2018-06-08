package com.androidflux.assestment.androidflux.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
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

    var rxFlux: RxFlux? = null
    var myStore: MyStore? = null
    var myActionCreator: MyActionCreators? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rxFlux = RxFlux.init(application)

        myStore = MyStore(rxFlux!!.dispatcher)
        myActionCreator = MyActionCreators(rxFlux!!.dispatcher, rxFlux!!.subscriptionManager)

        mBtnConnect.setOnClickListener {
            myActionCreator!!.connectWifi()
        }
    }

    override fun onRxViewUnRegistered() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRxStoreListToUnRegister(): MutableList<RxStore> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRxViewRegistered() {
    }

    override fun onRxError(error: RxError) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

    override fun getRxStoreListToRegister(): MutableList<RxStore?> {
        return mutableListOf(myStore)
    }

    override fun onRxStoreChanged(change: RxStoreChange) {
        when (change.storeId) {
            "MY_STORE" -> Toast.makeText(this, "Test", Toast.LENGTH_LONG).show()
        }
    }
}