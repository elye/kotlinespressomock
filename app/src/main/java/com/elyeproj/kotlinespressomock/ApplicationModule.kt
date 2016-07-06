package com.elyeproj.kotlinespressomock

import android.app.Application

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val mApplication: Application) {

    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    fun provideInjectedData(): InjectedData {
        return InjectedData()
    }
}
