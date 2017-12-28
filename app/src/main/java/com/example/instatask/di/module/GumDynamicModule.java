package com.example.instatask.di.module;

import com.example.instatask.presenter.GumActivityPresenter;
import com.example.instatask.view.GumActivityView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Igor Hnes on 12/26/17.
 */
@Module
public class GumDynamicModule {
    private GumActivityView view;

    public GumDynamicModule(GumActivityView view) {
        this.view = view;
    }

    /**
     *
     * @return GumActivityPresenter instance.
     */
    @Provides
    @Singleton
    GumActivityPresenter provideGumActivityPresenter() {
        return new GumActivityPresenter(view);
    }
}
