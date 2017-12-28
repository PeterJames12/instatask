package com.example.instatask.app;

import android.app.Application;

import com.example.instatask.di.component.AppComponent;
import com.example.instatask.di.component.DaggerAppComponent;

/**
 * @author Igor Hnes on 12/26/17.
 */
public class InstaApp extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    /**
     * @return AppComponent instance.
     */
    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .build();
    }
}
