package com.example.instatask.di.component;

import com.example.instatask.di.module.DetailActivityDynamicModule;
import com.example.instatask.view.DetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Igor Hnes on 12/26/17.
 */
@Singleton
@Component(modules = {DetailActivityDynamicModule.class})
public interface DetailComponent {

    void inject(DetailActivity activity);
}
