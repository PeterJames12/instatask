package com.example.instatask.di.module;

import com.example.instatask.model.api.InstaApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Igor Hnes on 12/26/17.
 */
@Module
public class ApiModule {
    private static final String SERVER_URL = "https://instasport.co/club/bright/";

    /**
     * @return retrofit instance.
     */
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();
    }

    /**
     * @param retrofit instance.
     * @return api class.
     */
    @Provides
    @Singleton
    InstaApi provideInstaApi(Retrofit retrofit) {
        return retrofit.create(InstaApi.class);
    }
}
