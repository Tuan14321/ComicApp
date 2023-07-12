package com.example.comicapp.API;

import com.example.comicapp.object.Chapter;
import com.example.comicapp.object.ViewChap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ViewChapApiEndPoint {

    @GET("api/Image")
    Call<List<ViewChap>> getAllViewChap(@Query("idChap") String idChap);
}
