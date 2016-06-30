package com.elyeproj.javadaggeruitest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
