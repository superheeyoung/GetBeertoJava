package com.example.myapplication.data;

import com.example.myapplication.domain.GetUserRepository;
import com.example.myapplication.model.BeerModel;
import java.util.List;
import io.reactivex.Single;

public class GetUserRepositoryImpl implements GetUserRepository {
    private GetUserRemoteSource getUserRemoteSource;

    private GetUserRepositoryImpl() {
        getUserRemoteSource = GetUserRemoteSourceImpl.getInstance();
    }

    public static GetUserRepository getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static class LazyHolder {
        private static final GetUserRepository INSTANCE= new GetUserRepositoryImpl();
    }

    @Override
    public Single<List<BeerModel>> getUser() {
        return getUserRemoteSource.getBeer();
    }
}



