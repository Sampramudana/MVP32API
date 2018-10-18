package com.example.sampramudana.mvp32api.Base;

public interface BasePresenter <T extends BaseView> {
    void onAttach(T v);
    void onDettach();
}
