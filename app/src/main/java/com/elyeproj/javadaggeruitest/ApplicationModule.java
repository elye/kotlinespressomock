package com.elyeproj.javadaggeruitest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    InjectedData provideInjectedData() {
        return new InjectedData();
    }
}
