package com.example.comicapp;

import com.example.comicapp.API.ChapterApiEndPoint;
import com.example.comicapp.API.ComicApiEndPoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServices {
    public static final String BASE_URL = "https://64adcbcab470006a5ec669f4.mockapi.io/";
    public static final String URL_CHAP = "https://64aec4f8c85640541d4dab86.mockapi.io/";

    private Retrofit retrofit;

    private ComicApiEndPoint comicApiEndPoint;
    private ChapterApiEndPoint chapterApiEndPoint;

    public APIServices() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        comicApiEndPoint = retrofit.create(ComicApiEndPoint.class);

        retrofit = new Retrofit.Builder().baseUrl(URL_CHAP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        chapterApiEndPoint = retrofit.create(ChapterApiEndPoint.class);
    }

    private static APIServices instance = null;
    public static APIServices getInstance() {
        if (instance == null) {
            instance = new APIServices();
        }
        return instance;
    }

    public ComicApiEndPoint getComicsApiEndPoint() {
        return comicApiEndPoint;
    }

    public ChapterApiEndPoint getChaptersApiEndPoint() {
        return chapterApiEndPoint;
    }

    public static ComicApiEndPoint getComicApiEndPoint() {
        return getInstance().getComicsApiEndPoint();
    }
    public static ChapterApiEndPoint getChapterApiEndPoint(){
        return getInstance().getChaptersApiEndPoint();

    }
}
