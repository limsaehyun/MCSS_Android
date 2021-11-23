package com.saehyun.mcss.di

import android.app.Application
import com.saehyun.mcss.di.module.searchModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class McssApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@McssApplication)

            modules(searchModule)

        }
    }
}