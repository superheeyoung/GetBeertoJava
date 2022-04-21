package com.example.myapplication.data;

import com.example.myapplication.data.api.BeerApi;
import com.example.myapplication.model.BeerModel;

import java.util.List;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetUserRemoteSourceImpl implements GetUserRemoteSource {

    private BeerApi beerApi;
    private static final String BASE_URL = "https://api.punkapi.com/v2/";

    @Override
    public Single<List<BeerModel>> getBeer() {
        beerApi = provideRetrofit().create(BeerApi.class);
        return beerApi.getBeerList(1, 20);
    }

    public static GetUserRemoteSource getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static class LazyHolder {
        private static final GetUserRemoteSource INSTANCE= new GetUserRemoteSourceImpl();
    }

    //retrofit settings
    static Retrofit provideRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
