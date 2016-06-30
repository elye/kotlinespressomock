package com.elyeproj.kotlinespressomock

import android.app.Application
import android.content.Context

class MainApplication : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    companion object {
        operator fun get(context: Context): MainApplication {
            return context.applicationContext as MainApplication
        }
    }
}
