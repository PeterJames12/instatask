package com.example.instatask.di.component;

import com.example.instatask.app.InstaApp;
import com.example.instatask.di.module.ApiModule;
import com.example.instatask.di.module.AppModule;
import com.example.instatask.presenter.BasePresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Igor Hnes on 12/26/17.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(InstaApp app);

    void inject(BasePresenter basePresenter);
}