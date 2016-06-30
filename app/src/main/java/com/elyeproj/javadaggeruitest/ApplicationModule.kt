package com.elyeproj.javadaggeruitest

import android.app.Application

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val mApplication: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    internal fun provideInjectedData(): InjectedData {
        return InjectedData()
    }
}
