package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.comicapp.adapter.ChapterAdapter;
import com.example.comicapp.adapter.ComicAdapter;
import com.example.comicapp.object.Chapter;
import com.example.comicapp.object.Comic;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapActivity extends AppCompatActivity {
    private String idtruyen;
    private Comic comic;
    private ImageView comicImages;
    private TextView comicNames;

    private RecyclerView rcvChapter;

    private ChapterAdapter chapterAdapter;

    private List<Chapter> mListChapter;


    private void BindingView() {
        rcvChapter = findViewById(R.id.rcvChap);
        comicImages = findViewById(R.id.ComicImages);
        comicNames = findViewById(R.id.tvComicNames);
    }

    private void BindingAction() {
        setUp();
    }

    private void setUp() {
        Intent intent = getIntent();
        if (intent != null) {
            comic = (Comic) intent.getSerializableExtra("comic");
            idtruyen = comic.getComicId();
        } else {
            Toast.makeText(this, "Comic null", Toast.LENGTH_SHORT).show();
        }
        comicNames.setText(comic.getComicName());
        Glide.with(this).load(comic.getImageLink()).into(comicImages);
    }

    private void listChapApi() {

        APIServices.getChapterApiEndPoint().getAllChapter(idtruyen).enqueue(new Callback<List<Chapter>>() {
            @Override
            public void onResponse(Call<List<Chapter>> call, Response<List<Chapter>> response) {
                mListChapter = response.body();
                chapterAdapter = new ChapterAdapter(ChapActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChapActivity.this);
                rcvChapter.setLayoutManager(linearLayoutManager);
                chapterAdapter.setDataChap(mListChapter);
                rcvChapter.setAdapter(chapterAdapter);
            }

            @Override
            public void onFailure(Call<List<Chapter>> call, Throwable t) {
                Toast.makeText(ChapActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap);
        BindingView();
        BindingAction();
        listChapApi();
    }
}