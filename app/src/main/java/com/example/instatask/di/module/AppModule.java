package com.example.instatask.di.module;

import android.app.Application;

import com.example.instatask.app.InstaApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Igor Hnes on 12/26/17.
 */
@Module
public class AppModule {

    private final InstaApp instaApp;

    public AppModule(InstaApp instaApp) {
        this.instaApp = instaApp;
    }

    /**
     * @return instance Application.
     */
    @Provides
    @Singleton
    public Application provideApplication() {
        return instaApp;
    }
}
