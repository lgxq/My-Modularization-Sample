package com.example.modulelization

import com.example.basebusiness.BaseApplication
import com.example.featurea.featureAServiceModule
import com.example.featureb.featureBServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */

class MyApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(featureAServiceModule, featureBServiceModule))
        }
    }
}