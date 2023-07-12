package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.comicapp.adapter.ChapterAdapter;
import com.example.comicapp.adapter.ViewChapAdapter;
import com.example.comicapp.object.Chapter;
import com.example.comicapp.object.ViewChap;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapView extends AppCompatActivity {

    private String idChap;
    private Chapter chapter;

    private ImageView viewChapImage;

    private RecyclerView rcvViewChap;

    private ViewChapAdapter viewChapAdapter;

    private List<ViewChap> mViewChapList;
    private void BindingView() {
        rcvViewChap = findViewById(R.id.rcvimgChap);
        viewChapImage = findViewById(R.id.imgChaps);
    }

    private void BindingAction() {
        setUp();
    }

    private void setUp() {
        Intent intent = getIntent();
        if (intent != null) {
            chapter = (Chapter) intent.getSerializableExtra("chapter");
            idChap = chapter.getChapId();
        } else {
            Toast.makeText(this, "Comic null", Toast.LENGTH_SHORT).show();
        }
    }

    private void listChapApi() {

        APIServices.getViewChapApiEndPoint().getAllViewChap(idChap).enqueue(new Callback<List<ViewChap>>() {
            @Override
            public void onResponse(Call<List<ViewChap>> call, Response<List<ViewChap>> response) {
                mViewChapList = response.body();
                viewChapAdapter = new ViewChapAdapter(ChapView.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChapView.this);
                rcvViewChap.setLayoutManager(linearLayoutManager);
                viewChapAdapter.setDataViewChap(mViewChapList);
                rcvViewChap.setAdapter(viewChapAdapter);
            }

            @Override
            public void onFailure(Call<List<ViewChap>> call, Throwable t) {
                Toast.makeText(ChapView.this, "Fail", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapview);
        BindingView();
        BindingAction();
        listChapApi();
    }
}