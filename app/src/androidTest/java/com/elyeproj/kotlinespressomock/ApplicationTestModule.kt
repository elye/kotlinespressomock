package com.elyeproj.kotlinespressomock

import android.app.Application

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock

@Module
class ApplicationTestModule(protected val mApplication: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    internal fun provideInjectedData(): InjectedData {
        return mock(InjectedData::class.java)
    }
}