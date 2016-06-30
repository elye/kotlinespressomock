package com.elyeproj.javadaggeruitest;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import static org.mockito.Mockito.mock;

@Module
public class ApplicationTestModule {
    protected final Application mApplication;
    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    InjectedData provideInjectedData() {
        return mock(InjectedData.class);
    }
}