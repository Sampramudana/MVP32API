package com.example.sampramudana.mvp32api.Main.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sampramudana.mvp32api.Main.Activity.MainActivity;
import com.example.sampramudana.mvp32api.Main.Activity.NewsActivity;
import com.example.sampramudana.mvp32api.Main.Model.ArticlesItem;
import com.example.sampramudana.mvp32api.Main.Model.Source;
import com.example.sampramudana.mvp32api.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    Context context;
    List<ArticlesItem> articlesItems;
    public String Weburl = "https://newsapi.org/v2/";

    public MainAdapter(Context context, List<ArticlesItem> data) {
        this.context = context;
        this.articlesItems = data;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.mainitem, viewGroup,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, final int i) {

        mainViewHolder.txtPublish.setText(articlesItems.get(i).getPublishedAt());
        mainViewHolder.txtTitle.setText(articlesItems.get(i).getTitle());
        mainViewHolder.txtAuthor.setText(articlesItems.get(i).getAuthor());
        mainViewHolder.txtDesc.setText(articlesItems.get(i).getDescription());
        Source source = (Source) articlesItems.get(i).getSource();
        mainViewHolder.txtName.setText(source.getName());

        Glide.with(context)
                .load(articlesItems.get(i).getUrlToImage())
                .into(mainViewHolder.image);

        mainViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsActivity.class);
                intent.putExtra("image", articlesItems.get(i).getUrlToImage());
                intent.putExtra("publish", articlesItems.get(i).getPublishedAt());
                intent.putExtra("title", articlesItems.get(i).getTitle());
                intent.putExtra("author", articlesItems.get(i).getAuthor());
                intent.putExtra("description", articlesItems.get(i).getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtTitle, txtAuthor, txtPublish, txtDesc;
        ImageView image;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtName = itemView.findViewById(R.id.txtname);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtPublish = itemView.findViewById(R.id.txtPublished);
            txtDesc = itemView.findViewById(R.id.txtDescription);
            image = itemView.findViewById(R.id.img);
        }
    }
}
