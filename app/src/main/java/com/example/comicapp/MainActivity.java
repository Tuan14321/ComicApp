package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.comicapp.API.ComicApiEndPoint;
import com.example.comicapp.adapter.ComicAdapter;
import com.example.comicapp.object.Comic;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvComic;
    private GridView a;

    private ComicAdapter comicAdapter;

    private SearchView searchView;

    private List<Comic> mListComic;

    private void BindingView() {
        rcvComic = findViewById(R.id.comicList);
        searchView = findViewById(R.id.searchView);
    }

    private void BindingAction() {
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text) {
        List<Comic> filterList = new ArrayList<>();
        for (Comic c : mListComic) {
            if (c.getComicName().toLowerCase().contains(text.toLowerCase())) {
                filterList.add(c);
            }
        }
        if (filterList.isEmpty()) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
            comicAdapter.setData(null);
        } else {
            comicAdapter.setData(filterList);
        }
        rcvComic.setAdapter(null);
        rcvComic.setAdapter(comicAdapter);
    }

    public void listComicApi() {
        APIServices.getComicApiEndPoint().getAllComics().enqueue(new Callback<List<Comic>>() {
            @Override
            public void onResponse(Call<List<Comic>> call, Response<List<Comic>> response) {
                mListComic = new ArrayList<>();
                mListComic = response.body();
                    comicAdapter = new ComicAdapter(MainActivity.this);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
                    rcvComic.setLayoutManager(gridLayoutManager);
                    comicAdapter.setData(mListComic);
                    rcvComic.setAdapter(comicAdapter);
            }
            @Override
            public void onFailure(Call<List<Comic>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void initGridView() {
//        comicAdapter = new ComicAdapter(this);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        rcvComic.setLayoutManager(gridLayoutManager);
//        comicAdapter.setData(listComicApi());
//        rcvComic.setAdapter(comicAdapter);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listComicApi();
        BindingView();
        BindingAction();
       //initGridView();
    }
}