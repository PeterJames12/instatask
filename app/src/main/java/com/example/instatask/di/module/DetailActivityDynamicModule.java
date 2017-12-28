package com.example.instatask.di.module;

import com.example.instatask.presenter.DetailActivityPresenter;
import com.example.instatask.view.DetailActivityView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Igor Hnes on 12/26/17.
 */
@Module
public class DetailActivityDynamicModule {
    private DetailActivityView view;

    public DetailActivityDynamicModule(DetailActivityView view) {
        this.view = view;
    }

    /**
     * @return DetailActivityPresenter.
     */
    @Singleton
    @Provides
    DetailActivityPresenter provideDetailActivityPresenter() {
        return new DetailActivityPresenter(view);
    }
}
