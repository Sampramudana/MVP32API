package com.example.sampramudana.mvp32api.Main.View;

import com.example.sampramudana.mvp32api.Base.BaseView;
import com.example.sampramudana.mvp32api.Main.Model.ArticlesItem;
import com.example.sampramudana.mvp32api.Main.Model.ResponseData;

import java.util.List;

public interface MainView extends BaseView {
    void onError(String msg);
    void onSuccess(List<ArticlesItem> data);
}
