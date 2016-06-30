package com.elyeproj.javadaggeruitest;

import android.app.Application;

public class MainApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
