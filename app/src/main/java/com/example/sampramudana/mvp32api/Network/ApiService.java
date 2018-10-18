package com.example.sampramudana.mvp32api.Network;

import com.example.sampramudana.mvp32api.Main.Model.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("everything?sources=nfl-news&apiKey=0a3624cc60104378b8ac6bb15d4dcd78")
    Call<ResponseData> getDataNFL();
}
