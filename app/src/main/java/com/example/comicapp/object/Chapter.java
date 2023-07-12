package com.example.comicapp.object;

import com.google.gson.annotations.SerializedName;

public class Chapter {
    private String ChapId;
    @SerializedName("tenchap")
    private String ChapterName;
    @SerializedName("ngaynhap")
    private String DatePost;

    public Chapter(String chapId, String chapterName, String datePost) {
        ChapId = chapId;
        ChapterName = chapterName;
        DatePost = datePost;
    }

    public String getChapId() {
        return ChapId;
    }

    public void setChapId(String chapId) {
        ChapId = chapId;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public String getDatePost() {
        return DatePost;
    }

    public void setDatePost(String datePost) {
        DatePost = datePost;
    }
}
