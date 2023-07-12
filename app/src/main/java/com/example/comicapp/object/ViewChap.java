package com.example.comicapp.object;

import com.google.gson.annotations.SerializedName;

public class ViewChap {
    @SerializedName("id")
    private String ViewChapId;
    @SerializedName("anh")
    private String ImgViewChap;
    @SerializedName("idChap")
    private String ChapterId;

    public ViewChap(String viewChapId, String imgViewChap, String chapterId) {
        ViewChapId = viewChapId;
        ImgViewChap = imgViewChap;
        ChapterId = chapterId;
    }

    public String getViewChapId() {
        return ViewChapId;
    }

    public void setViewChapId(String viewChapId) {
        ViewChapId = viewChapId;
    }

    public String getImgViewChap() {
        return ImgViewChap;
    }

    public void setImgViewChap(String imgViewChap) {
        ImgViewChap = imgViewChap;
    }

    public String getChapterId() {
        return ChapterId;
    }

    public void setChapterId(String chapterId) {
        ChapterId = chapterId;
    }
}
