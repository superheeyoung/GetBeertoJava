package com.example.myapplication.domain;

import com.example.myapplication.model.BeerModel;
import java.util.List;
import io.reactivex.Single;

public interface GetUserRepository {
    Single<List<BeerModel>> getUser();
}
