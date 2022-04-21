package com.example.myapplication.data;

import com.example.myapplication.model.BeerModel;
import java.util.List;
import io.reactivex.Single;

public interface GetUserRemoteSource {
    Single<List<BeerModel>> getBeer();
}
