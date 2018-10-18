package com.example.sampramudana.mvp32api.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static String webUrl = "https://newsapi.org/v2/";

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(webUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
