package com.example.instatask.presenter;

import com.example.instatask.app.InstaApp;
import com.example.instatask.model.api.InstaApi;

import javax.inject.Inject;

/**
 * @author Igor Hnes on 12/26/17.
 */
public abstract class BasePresenter {

    @Inject
    protected InstaApi instaApi;

    public BasePresenter() {
        InstaApp.getComponent().inject(this);
    }
}
