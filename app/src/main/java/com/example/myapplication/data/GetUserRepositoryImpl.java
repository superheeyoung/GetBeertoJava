package com.example.myapplication.data;

import com.example.myapplication.domain.GetUserRepository;
import com.example.myapplication.model.BeerModel;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetUserRepositoryImpl implements GetUserRepository {
    private GetUserRemoteSource getUserRemoteSource;

    @Inject
    public GetUserRepositoryImpl(GetUserRemoteSource getUserRemoteSource) {
        this.getUserRemoteSource = getUserRemoteSource;
    }

    @Override
    public Single<List<BeerModel>> getUser() {
        return getUserRemoteSource.getBeer();
    }
}



