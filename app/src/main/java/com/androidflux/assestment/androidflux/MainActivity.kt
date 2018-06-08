package com.androidflux.assestment.androidflux

import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidflux.assestment.androidflux.action.ConnectWifiActionCreator
import com.androidflux.assestment.androidflux.dagger.DaggerApplicationComponent
import com.androidflux.assestment.androidflux.dagger.component
import com.androidflux.assestment.androidflux.store.NumberStore
import com.hardsoftstudio.rxflux.action.RxError
import com.hardsoftstudio.rxflux.dispatcher.RxViewDispatch
import com.hardsoftstudio.rxflux.store.RxStore
import com.hardsoftstudio.rxflux.store.RxStoreChange
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), RxViewDispatch {
    private val TAG = "MAINACTIVITY"

    @Inject
    lateinit var connectWifiActionCreator: ConnectWifiActionCreator

    @Inject
    lateinit var store: NumberStore

    @Inject
    lateinit var app: Application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)
        mBtnConnect.setOnClickListener {
            store.getNumbers()
        }

    }

    override fun onRxViewUnRegistered() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRxStoreListToUnRegister(): MutableList<RxStore> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRxViewRegistered() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRxError(error: RxError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRxStoreListToRegister(): MutableList<RxStore>? {
        return mutableListOf(store)
    }

    override fun onRxStoreChanged(change: RxStoreChange) {
    }
}