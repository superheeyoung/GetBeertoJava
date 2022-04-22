package com.example.myapplication.di;

import com.example.myapplication.data.GetUserRemoteSource;
import com.example.myapplication.data.GetUserRemoteSourceImpl;
import com.example.myapplication.data.GetUserRepositoryImpl;
import com.example.myapplication.data.api.BeerApi;
import com.example.myapplication.domain.GetUserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class RepositoryModule {
    @Provides
    @Singleton
    public GetUserRemoteSource getUserRemoteSource(BeerApi beerApi) {
        return new GetUserRemoteSourceImpl(beerApi);
    }

    @Provides
    @Singleton
    public GetUserRepository getUserRepository(GetUserRemoteSource getUserRemoteSource) {
        return new GetUserRepositoryImpl(getUserRemoteSource);
    }
}
