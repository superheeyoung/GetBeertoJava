package com.example.myapplication.data;

import com.example.myapplication.data.api.BeerApi;
import com.example.myapplication.model.BeerModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetUserRemoteSourceImpl implements GetUserRemoteSource {

    private BeerApi beerApi;

    @Inject
    public GetUserRemoteSourceImpl(BeerApi beerApi) {
        this.beerApi = beerApi;
    }

    @Override
    public Single<List<BeerModel>> getBeer() {
        return beerApi.getBeerList(1, 20);
    }
}
