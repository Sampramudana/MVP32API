package com.example.sampramudana.mvp32api.Main.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sampramudana.mvp32api.Main.Adapter.MainAdapter;
import com.example.sampramudana.mvp32api.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.relative)
    RelativeLayout relative;
    @BindView(R.id.published)
    TextView published;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.description)
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        String detailAuthor = getIntent().getStringExtra("author");
        String detailPublished = getIntent().getStringExtra("published");
        String detailDescription = getIntent().getStringExtra("description");
        String detailTitle = getIntent().getStringExtra("title");
        String detailGambar = getIntent().getStringExtra("image");

        author.setText(detailAuthor);
        published.setText(detailPublished);
        description.setText(detailDescription);
        title.setText(detailTitle);

        Glide.with(this)
                .load(detailGambar)
                .into(image);
    }
}
