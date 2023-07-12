package com.example.comicapp.API;

import com.example.comicapp.object.Chapter;
import com.example.comicapp.object.Comic;

import java.util.List;

import kotlin.ParameterName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChapterApiEndPoint {
    @GET("api/Chapter")
    Call<List<Chapter>> getAllChapter(@Query("idtruyen") String idtruyen);
}
