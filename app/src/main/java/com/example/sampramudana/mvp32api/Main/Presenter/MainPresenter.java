package com.example.sampramudana.mvp32api.Main.Presenter;

import com.example.sampramudana.mvp32api.Base.BasePresenter;
import com.example.sampramudana.mvp32api.Main.Model.ArticlesItem;
import com.example.sampramudana.mvp32api.Main.Model.ResponseData;
import com.example.sampramudana.mvp32api.Main.View.MainView;
import com.example.sampramudana.mvp32api.Network.ConfigRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView>{

    MainView mainView;

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDettach() {
        mainView = null;
    }

    public void getData() {
        call().enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful()) {
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSuccess(articlesItems);
                } else {
                    mainView.onError("Gagal Mengambil Data");
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    public Call<ResponseData> call() {
        return ConfigRetrofit.getInstance().getDataNFL();
    }
}
