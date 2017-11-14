package com.money.moneytracker.api;


import com.money.moneytracker.item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 09.11.2017.
 */

public interface Api {


    @GET("items")

    Call<List<item>> items(@Query("type")String type);

}
