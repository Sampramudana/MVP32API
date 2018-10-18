package com.example.sampramudana.mvp32api.Main.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sampramudana.mvp32api.Main.Adapter.MainAdapter;
import com.example.sampramudana.mvp32api.Main.Model.ArticlesItem;
import com.example.sampramudana.mvp32api.Main.Presenter.MainPresenter;
import com.example.sampramudana.mvp32api.Main.View.MainView;
import com.example.sampramudana.mvp32api.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.recyclerNFL)
    RecyclerView recyclerNFL;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenter();
        onAttachView();
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onSuccess(List<ArticlesItem> data) {
        recyclerNFL.setLayoutManager(new LinearLayoutManager(this));
        recyclerNFL.setAdapter(new MainAdapter(MainActivity.this, data));
    }

    @Override
    public void onAttachView() {
        mainPresenter.onAttach(this);
        mainPresenter.getData();
    }

    @Override
    public void onDettachView() {

    }
}
