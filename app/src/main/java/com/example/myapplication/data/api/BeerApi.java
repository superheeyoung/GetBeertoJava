package com.example.myapplication.data.api;

import com.example.myapplication.model.BeerModel;
import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeerApi {
    @GET("beers")
    Single<List<BeerModel>> getBeerList(
            @Query("page") int pageCount,
            @Query("per_page") int perPage);
}
