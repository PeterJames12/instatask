package com.example.instatask.di.component;

import com.example.instatask.di.module.GumDynamicModule;
import com.example.instatask.view.impl.GumActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Igor Hnes on 12/26/17.
 */
@Singleton
@Component(modules = {GumDynamicModule.class})
public interface GumComponent {

    void inject(GumActivity activity);
}
